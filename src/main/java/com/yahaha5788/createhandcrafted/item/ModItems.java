package com.yahaha5788.createhandcrafted.item;

import com.yahaha5788.createhandcrafted.CreateHandcrafted;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CreateHandcrafted.MODID);

    public static final RegistryObject<Item> GILDED_ALLOY = ITEMS.register("gilded_alloy",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
