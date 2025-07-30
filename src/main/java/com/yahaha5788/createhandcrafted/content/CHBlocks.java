package com.yahaha5788.createhandcrafted.content;

import com.tterrag.registrate.util.entry.BlockEntry;

import com.yahaha5788.createhandcrafted.CreateHandcrafted;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.Tags;

import static com.simibubi.create.foundation.data.BlockStateGen.simpleCubeAll;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;



public class CHBlocks {

    static {
        CreateHandcrafted.REGISTRATE.setCreativeTab(CHCreativeTabs.CH_MAIN_TAB);
    }

//    public static final BlockEntry<Block> GILDED_OBSIDIAN =
//            CreateHandcrafted.REGISTRATE.block("gilded_obsidian", Block::new)
//                    .register();

    public static final BlockEntry<Block> GILDED_OBSIDIAN = CreateHandcrafted.REGISTRATE.block("gilded_obsidien", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BLACK)
                    .requiresCorrectToolForDrops())
            .transform(pickaxeOnly())
            .blockstate(simpleCubeAll("gilded_obsidian"))
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .transform(tagBlockAndItem("storage_blocks/brass"))
            .tag(Tags.Items.STORAGE_BLOCKS)
            .build()
            .register();

    public static void register() {

    }

}
