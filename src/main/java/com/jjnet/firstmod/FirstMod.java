package com.jjnet.firstmod;

import com.jjnet.firstmod.blocks.FirstBlock;
import com.jjnet.firstmod.blocks.ModBlocks;
import com.jjnet.firstmod.blocks.SecondBlock;
import com.jjnet.firstmod.setup.ClientProxy;
import com.jjnet.firstmod.setup.IProxy;
import com.jjnet.firstmod.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.DistExecutor;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("firstmod")
public class FirstMod {
    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    private static final Logger LOGGER = LogManager.getLogger();

    public FirstMod() {
        // Register the com.jjnet.firstmod.setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new FirstBlock());
            event.getRegistry().register(new SecondBlock());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(ModBlocks.FIRSTBLOCK, new Item.Properties()).setRegistryName("firstblock"));
            event.getRegistry().register(new BlockItem(ModBlocks.SECONDBLOCK, new Item.Properties()).setRegistryName("secondblock"));
        }
    }
}
