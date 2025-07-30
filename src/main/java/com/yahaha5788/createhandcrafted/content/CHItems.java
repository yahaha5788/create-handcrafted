package com.yahaha5788.createhandcrafted.content;

import com.tterrag.registrate.util.entry.ItemEntry;

import com.yahaha5788.createhandcrafted.CreateHandcrafted;
import net.minecraft.world.item.Item;


public class CHItems {

    static {
        CreateHandcrafted.REGISTRATE.setCreativeTab(CHCreativeTabs.CH_MAIN_TAB);
    }

    public static final ItemEntry<Item> GILDED_ALLOY =
        CreateHandcrafted.REGISTRATE.item("gilded_alloy", Item::new)
        .register();

    public static void register() {

    }

}
