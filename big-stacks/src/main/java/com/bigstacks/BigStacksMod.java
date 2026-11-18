package com.bigstacks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Big Stacks: every item that normally stacks (64, 16, ...) stacks to {@link #MAX_STACK}.
 * Items that never stack (tools, armor, potions, ...) are left alone.
 *
 * Install on both the client and the server.
 */
public class BigStacksMod implements ModInitializer {
    public static final String MOD_ID = "bigstacks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    /** The new stack limit. */
    public static final int MAX_STACK = 999;

    @Override
    public void onInitialize() {
        DefaultItemComponentEvents.MODIFY.register(context ->
                context.modify(
                        item -> item.getDefaultMaxStackSize() > 1,
                        (builder, item) -> builder.set(DataComponents.MAX_STACK_SIZE, MAX_STACK)));

        // Self-check: shows up in the log so you can confirm the mod is working.
        ServerLifecycleEvents.SERVER_STARTED.register(server ->
                LOGGER.info("Big Stacks active: stone stacks to {}, diamond sword stacks to {}",
                        new ItemStack(Items.STONE).getMaxStackSize(),
                        new ItemStack(Items.DIAMOND_SWORD).getMaxStackSize()));
    }
}
