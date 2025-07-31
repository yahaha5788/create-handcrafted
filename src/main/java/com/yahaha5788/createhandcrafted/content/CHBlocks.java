package com.yahaha5788.createhandcrafted.content;

import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.Create;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.foundation.data.BuilderTransformers;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
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
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;


public class CHBlocks {

    static {
        CreateHandcrafted.REGISTRATE.setCreativeTab(CHCreativeTabs.CH_MAIN_TAB);
    }

    public static final BlockEntry<Block> GILDED_OBSIDIAN = CreateHandcrafted.REGISTRATE.block("gilded_obsidian", Block::new)
            .initialProperties(() -> Blocks.IRON_BLOCK)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BLACK)
                    .requiresCorrectToolForDrops())
            .transform(pickaxeOnly())
            .tag(BlockTags.NEEDS_DIAMOND_TOOL)
            .transform(tagBlockAndItem("obsidians"))
            .build()
            .blockstate(simpleCubeAll("gilded_obsidian"))
            .register();

    static {
        CreateHandcrafted.REGISTRATE.setCreativeTab(CHCreativeTabs.CH_DECO_TAB);
    }
    public static final BlockEntry<Block> GILDED_CASING = CreateHandcrafted.REGISTRATE.block("gilded_casing", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BLACK)
                    .requiresCorrectToolForDrops())
            .transform(pickaxeOnly())
            .transform(tagBlockAndItem("obsidians"))
            .build()
            .register();

    public static final BlockEntry<CasingBlock> GOLD_CASING = CreateHandcrafted.REGISTRATE.block("gold_casing", CasingBlock::new)
            .properties(p -> p.mapColor(MapColor.GOLD))
            .transform(BuilderTransformers.casing(() -> CHTextureShifts.GOLD_CASING))
            .register();



    public static void register() {

    }

}
