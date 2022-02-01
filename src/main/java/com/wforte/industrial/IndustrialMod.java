package com.wforte.industrial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.wforte.industrial.core.init.BiomeInit;
import com.wforte.industrial.core.init.BlockInit;
import com.wforte.industrial.core.init.ContainerTypesInit;
import com.wforte.industrial.core.init.ItemInit;
import com.wforte.industrial.core.init.SurfaceBuilderInit;
import com.wforte.industrial.core.init.TileEntityTypesInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("industrial")
@Mod.EventBusSubscriber(modid = IndustrialMod.MOD_ID, bus = Bus.MOD)
public class IndustrialMod {
	
	private static final Logger LOGGER = LogManager.getLogger();
	public static final String MOD_ID = "industrial";

	public IndustrialMod() {

		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
		TileEntityTypesInit.TILE_ENTITY_TYPE.register(bus);
		ContainerTypesInit.CONTAINER_TYPES.register(bus);
		SurfaceBuilderInit.SURFACE_BUILDERS.register(bus);
		BiomeInit.BIOMES.register(bus);
		BiomeInit.registerBiomes();
		
		MinecraftForge.EVENT_BUS.register(this);
	}

}
