package com.yahaha5788.cfstuff.mixins;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Enchantment.class)
public class TridentEnchantabilityMixin { // just rolls off the tongue

    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    public void canEnchant(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {

        if (stack.getItem() == Items.TRIDENT) {
            if (this.equals(Enchantments.MOB_LOOTING) || this.equals(Enchantments.SHARPNESS)) {
                cir.setReturnValue(true);
                cir.cancel();
            }
        }
    }
}
