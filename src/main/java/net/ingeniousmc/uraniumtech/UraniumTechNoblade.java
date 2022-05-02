package net.ingeniousmc.uraniumtech;

import net.ingeniousmc.uraniumtech.block.ModBlocks;
import net.ingeniousmc.uraniumtech.item.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UraniumTechNoblade.MOD_ID)
public class UraniumTechNoblade {
    public static final String MOD_ID = "uraniumtech";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    // Add a comment
    public UraniumTechNoblade() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }
}