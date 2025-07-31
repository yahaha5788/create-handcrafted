package com.yahaha5788.createhandcrafted.content;

import com.tterrag.registrate.util.entry.RegistryEntry;
import com.yahaha5788.createhandcrafted.CreateHandcrafted;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import it.unimi.dsi.fastutil.objects.ReferenceLinkedOpenHashSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.*;


import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


public class CHCreativeTabs {

    private static final DeferredRegister<CreativeModeTab> CREATIVE_TAB_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateHandcrafted.MODID);

    public static final RegistryObject<CreativeModeTab> CH_MAIN_TAB = CREATIVE_TAB_REGISTER.register("main",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.main"))
                    .icon(CHBlocks.GILDED_CASING::asStack)
                    .displayItems(new MainDisplayItemsGen())
                    .build());

    public static final RegistryObject<CreativeModeTab> CH_DECO_TAB = CREATIVE_TAB_REGISTER.register("deco", // deco soon, trust
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetabs.deco"))
                    .icon(CHBlocks.GOLD_CASING::asStack)
                    .displayItems(new DecoDisplayItemsGen())
                    .build());


    public static void register(IEventBus modEventBus) {
        CREATIVE_TAB_REGISTER.register(modEventBus);
    }

    public static class MainDisplayItemsGen implements CreativeModeTab.DisplayItemsGenerator {

        private List<Item> collectBlocks(RegistryObject<CreativeModeTab> tab, Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();
            for (RegistryEntry<Block> entry : CreateHandcrafted.REGISTRATE.getAll(Registries.BLOCK)) {
                if (!CreateHandcrafted.REGISTRATE.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get().asItem();
                if (item == Items.AIR)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            items = new ReferenceArrayList<>(new ReferenceLinkedOpenHashSet<>(items));
            System.out.println("collected" + items);
            return items;
        }

        private List<Item> collectItems(RegistryObject<CreativeModeTab> tab, Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();

            for (RegistryEntry<Item> entry : CreateHandcrafted.REGISTRATE.getAll(Registries.ITEM)) {
                if (!CreateHandcrafted.REGISTRATE.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get();
                if (item instanceof BlockItem)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            System.out.println("collected" + items);
            return items;
        }

        private static void outputAll(CreativeModeTab.Output output, List<Item> items) {
            for (Item item : items) {
                output.accept(item);
            }
        }

        @Override
        public void accept(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {
            List<Item> items = new LinkedList<>();
            items.addAll(collectBlocks(CH_MAIN_TAB, (item) -> { return false; })); //will use when adding compat
            items.addAll(collectItems(CH_MAIN_TAB, (item) -> { return false; }));

            outputAll(output, items);
        }
    }

    public static class DecoDisplayItemsGen implements CreativeModeTab.DisplayItemsGenerator {

        private List<Item> collectBlocks(RegistryObject<CreativeModeTab> tab, Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();
            for (RegistryEntry<Block> entry : CreateHandcrafted.REGISTRATE.getAll(Registries.BLOCK)) {
                if (!CreateHandcrafted.REGISTRATE.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get().asItem();
                if (item == Items.AIR)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            items = new ReferenceArrayList<>(new ReferenceLinkedOpenHashSet<>(items));
            return items;
        }

        private List<Item> collectItems(RegistryObject<CreativeModeTab> tab, Predicate<Item> exclusionPredicate) {
            List<Item> items = new ReferenceArrayList<>();

            for (RegistryEntry<Item> entry : CreateHandcrafted.REGISTRATE.getAll(Registries.ITEM)) {
                if (!CreateHandcrafted.REGISTRATE.isInCreativeTab(entry, tab))
                    continue;
                Item item = entry.get();
                if (item instanceof BlockItem)
                    continue;
                if (!exclusionPredicate.test(item))
                    items.add(item);
            }
            return items;
        }

        private static void outputAll(CreativeModeTab.Output output, List<Item> items) {
            for (Item item : items) {
                output.accept(item);
            }
        }

        @Override
        public void accept(CreativeModeTab.ItemDisplayParameters params, CreativeModeTab.Output output) {
            List<Item> items = new LinkedList<>();
            items.addAll(collectBlocks(CH_DECO_TAB, (item) -> { return false; })); //will use when adding compat
            items.addAll(collectItems(CH_DECO_TAB, (item) -> { return false; }));

            outputAll(output, items);
        }
    }
}
