package com.yahaha5788.cfstuff.listeners;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TridentEnchantHandler {

    @SubscribeEvent
    public static void onAnvilCombine(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (!(left.getItem() instanceof TridentItem)) return; // this only applies to tridents as of right now

        if (!(right.getItem() instanceof net.minecraft.world.item.EnchantedBookItem)) return; // only allow books, other methods are buggy

        Map<Enchantment, Integer> rightEnchants = EnchantmentHelper.getEnchantments(right);
        if (rightEnchants.isEmpty()) return;

        ItemStack result = left.copy(); // copy left item (trident) for result
        Map<Enchantment, Integer> leftEnchants = EnchantmentHelper.getEnchantments(result);

        boolean modified = false;

        for (Map.Entry<Enchantment, Integer> entry : rightEnchants.entrySet()) {
            Enchantment ench = entry.getKey();
            int level = entry.getValue();

            if (ench != Enchantments.SHARPNESS && ench != Enchantments.MOB_LOOTING) continue; // normal behavior for enchants other than sharpness & looting

            int currentLevel = leftEnchants.getOrDefault(ench, 0);
            if (level > currentLevel) {
                leftEnchants.put(ench, level);
                modified = true;
            }
        }

        if (modified) {
            EnchantmentHelper.setEnchantments(leftEnchants, result);
            event.setOutput(result);

            event.setCost(1);
        }
    }

}
