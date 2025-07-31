package com.yahaha5788.createhandcrafted.content;

import com.tterrag.registrate.util.entry.ItemEntry;

import com.yahaha5788.createhandcrafted.CreateHandcrafted;
import net.minecraft.world.item.Item;


public class CHItems {

    static {
        CreateHandcrafted.REGISTRATE.setCreativeTab(CHCreativeTabs.CH_MAIN_TAB);
    }

    public static final ItemEntry<Item> COPPER_WHISK =
            CreateHandcrafted.REGISTRATE.item("copper_whisk", Item::new)
                    .register();

    public static final ItemEntry<Item> BRASS_WHISK =
            CreateHandcrafted.REGISTRATE.item("brass_whisk", Item::new)
                    .register();

    public static final ItemEntry<Item> GILDED_WHISK =
            CreateHandcrafted.REGISTRATE.item("gilded_whisk", Item::new)
                    .register();

    public static void register() {

    }

}
