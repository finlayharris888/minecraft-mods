package com.bigstacks.mixin;

import com.bigstacks.BigStacksMod;
import net.minecraft.world.item.ItemStackTemplate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/** Same 99 limit, in the template used for items stored inside other items (bundles, shulkers). */
@Mixin(ItemStackTemplate.class)
public class ItemStackTemplateMixin {
    @ModifyConstant(method = "lambda$static$0", constant = @Constant(intValue = 99))
    private static int bigstacks$codecLimit(int original) {
        return BigStacksMod.MAX_STACK;
    }
}
