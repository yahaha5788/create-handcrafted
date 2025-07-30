package com.yahaha5788.createhandcrafted;

import com.mojang.logging.LogUtils;
import com.yahaha5788.createhandcrafted.content.CHBlocks;
import com.yahaha5788.createhandcrafted.content.CHCreativeTabs;
import com.yahaha5788.createhandcrafted.content.CHItems;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import com.simibubi.create.foundation.data.CreateRegistrate;


@Mod(CreateHandcrafted.MODID)
public class CreateHandcrafted
{
    public static final String MODID = "createhandcrafted";

    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(CreateHandcrafted.MODID);


    public CreateHandcrafted(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        CHCreativeTabs.register(modEventBus);
        REGISTRATE.registerEventListeners(modEventBus);
        CHItems.register();
        CHBlocks.register();
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Handcrafted is setting up common, and doing it inconveniently");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Handcrafted is starting up common, and doing it inconveniently");
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            LOGGER.info("salutations");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
