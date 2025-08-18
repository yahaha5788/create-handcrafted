package com.yahaha5788.cfstuff.mixins;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.spongepowered.asm.mixin.Mixin;

import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import uwu.lopyluna.create_bnz.registry.BZItems;

@Mixin(Enchantment.class)
public class BlockZapperMendingMixin {

    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    public void canEnchant(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {

        if (stack.getItem() == BZItems.BLOCK_ZAPPER.asItem()) {
            if (this.equals(Enchantments.MENDING)) {
                cir.setReturnValue(true);
                cir.cancel();
            }
        }
    }
}
