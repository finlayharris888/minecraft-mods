package com.bigstacks.mixin;

import com.bigstacks.BigStacksMod;
import net.minecraft.world.Container;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/** Containers (chests, barrels, player inventory, ...) normally refuse stacks over 99. */
@Mixin(Container.class)
public interface ContainerMixin {
    @ModifyConstant(method = "getMaxStackSize()I", constant = @Constant(intValue = 99))
    private int bigstacks$containerLimit(int original) {
        return BigStacksMod.MAX_STACK;
    }
}
