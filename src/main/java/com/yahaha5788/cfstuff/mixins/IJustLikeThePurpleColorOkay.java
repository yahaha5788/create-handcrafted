package com.yahaha5788.cfstuff.mixins;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class IJustLikeThePurpleColorOkay {

    @Inject(method = "getRarity", at = @At("HEAD"), cancellable = true)
    public void getRarity(ItemStack pStack, CallbackInfoReturnable<Rarity> cir) {
        if (pStack.getItem() == Items.TRIDENT && pStack.isEnchanted()) {
            cir.setReturnValue(Rarity.EPIC);
            cir.cancel();
        }
    }

}