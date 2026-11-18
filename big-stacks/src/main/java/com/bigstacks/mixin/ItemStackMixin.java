package com.bigstacks.mixin;

import com.bigstacks.BigStacksMod;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/** The saved-item format rejects counts over 99, which would delete big stacks on save. */
@Mixin(ItemStack.class)
public class ItemStackMixin {
    @ModifyConstant(method = "lambda$static$1", constant = @Constant(intValue = 99))
    private static int bigstacks$codecLimit(int original) {
        return BigStacksMod.MAX_STACK;
    }
}
