package com.yahaha5788.cfstuff.mixins;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.mcreator.createstuffadditions.init.CreateSaModEnchantments;
import net.mcreator.createstuffadditions.init.CreateSaModItems;


@Mixin(Enchantment.class)
public class JetpackAboveTheCloudsMixin {

    @Inject(method = "canEnchant", at = @At("HEAD"), cancellable = true)
    public void canEnchant(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.getItem().asItem() == CreateSaModItems.ANDESITE_JETPACK_CHESTPLATE.get().asItem() ||
                stack.getItem().asItem() == CreateSaModItems.COPPER_JETPACK_CHESTPLATE.get().asItem() ||
                stack.getItem().asItem() == CreateSaModItems.BRASS_JETPACK_CHESTPLATE.get().asItem() ||
                stack.getItem().asItem() == CreateSaModItems.NETHERITE_JETPACK_CHESTPLATE.get().asItem()) {
            if (this.equals(CreateSaModEnchantments.ABOVE_THE_CLOUDS.get())) {
                cir.setReturnValue(true);
                cir.cancel();
            }
        }
    }
}
