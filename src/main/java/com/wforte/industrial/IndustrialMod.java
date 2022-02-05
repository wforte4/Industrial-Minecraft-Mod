package com.wforte.industrial;

import com.google.common.collect.ImmutableMap;
import com.wforte.industrial.common.item.ModSpawnEggItem;
import com.wforte.industrial.entity.ModEntityTypes;
import com.wforte.industrial.entity.custom.BuffZombieEntity;
import com.wforte.industrial.entity.custom.HogEntity;
import com.wforte.industrial.entity.custom.KnuckleDraggerEntity;
import com.wforte.industrial.entity.render.BuffZombieRenderer;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.AxeItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
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
		bus.addListener(this::commonSetup);

		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
		TileEntityTypesInit.TILE_ENTITY_TYPE.register(bus);
		ContainerTypesInit.CONTAINER_TYPES.register(bus);
		SurfaceBuilderInit.SURFACE_BUILDERS.register(bus);
		BiomeInit.BIOMES.register(bus);
		BiomeInit.registerBiomes();
		ModEntityTypes.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);
	}

	public void commonSetup(final FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)
					.put(BlockInit.LAVENDER_LOG.get(), BlockInit.LAVENDER_STRIPPED_LOG.get()).build();
		});
		DeferredWorkQueue.runLater(() -> {
			GlobalEntityTypeAttributes.put(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.KNUCKLE_DRAGGER.get(), KnuckleDraggerEntity.setCustomAttributes().create());
			GlobalEntityTypeAttributes.put(ModEntityTypes.HOG.get(), HogEntity.setCustomAttributes().create());
		});
	}

	@SubscribeEvent
	public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event) {
		ModSpawnEggItem.initSpawnEggs();
	}

}
