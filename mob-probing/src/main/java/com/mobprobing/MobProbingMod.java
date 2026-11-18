package com.mobprobing;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.phys.AABB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Minecraft Mob Probing: every hostile mob within RADIUS blocks of a player
 * is steered towards that player.
 */
public class MobProbingMod implements ModInitializer {
    public static final String MOD_ID = "mobprobing";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    /** How far (in blocks) mobs are drawn from. */
    public static final double RADIUS = 200.0;
    /** Ticks between re-aiming mobs (20 ticks = 1 second). */
    private static final int INTERVAL_TICKS = 20;
    /** Mobs closer than this are left to their normal AI. */
    private static final double LEAVE_ALONE_DISTANCE = 3.0;
    /** Mobs closer than this are also given the player as an attack target. */
    private static final double TARGET_DISTANCE = 40.0;
    /** Pathfinding only works over short hops, so mobs walk to waypoints this far away. */
    private static final double WAYPOINT_STEP = 20.0;
    private static final double MOVE_SPEED = 1.1;

    @Override
    public void onInitialize() {
        ServerTickEvents.END_LEVEL_TICK.register(this::tickLevel);
        LOGGER.info("Minecraft Mob Probing loaded: hostile mobs within {} blocks will hunt players.", (int) RADIUS);
    }

    private void tickLevel(ServerLevel level) {
        if (level.getGameTime() % INTERVAL_TICKS != 0) return;

        for (ServerPlayer player : level.players()) {
            if (player.isSpectator() || player.isCreative() || !player.isAlive()) continue;

            AABB area = player.getBoundingBox().inflate(RADIUS);
            List<Mob> mobs = level.getEntitiesOfClass(
                    Mob.class, area, m -> m instanceof Enemy && m.isAlive());

            for (Mob mob : mobs) {
                probe(mob, player);
            }
        }
    }

    private void probe(Mob mob, ServerPlayer player) {
        double dx = player.getX() - mob.getX();
        double dy = player.getY() - mob.getY();
        double dz = player.getZ() - mob.getZ();
        double dist = Math.sqrt(dx * dx + dy * dy + dz * dz);

        if (dist > RADIUS || dist < LEAVE_ALONE_DISTANCE) return;

        if (dist <= TARGET_DISTANCE && mob.getTarget() == null) {
            mob.setTarget(player);
        }

        // Walk towards the player in hops the pathfinder can handle.
        double scale = Math.min(dist, WAYPOINT_STEP) / dist;
        mob.getNavigation().moveTo(
                mob.getX() + dx * scale,
                mob.getY() + dy * scale,
                mob.getZ() + dz * scale,
                MOVE_SPEED);
    }
}
