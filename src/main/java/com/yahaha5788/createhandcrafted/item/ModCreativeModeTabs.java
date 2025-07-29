package com.yahaha5788.createhandcrafted.item;

import com.yahaha5788.createhandcrafted.CreateHandcrafted;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateHandcrafted.MODID);

    public static final RegistryObject<CreativeModeTab> CREATE_HANDCRAFTED_TAB = CREATIVE_MODE_TABS.register("create_handcrafted_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.GILDED_ALLOY.get()))
                    .title(Component.translatable("creativetab.create_handcrafted_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.GILDED_ALLOY.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
