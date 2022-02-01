package com.wforte.industrial.core.util;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.client.screen.DisplayCaseScreen;
import com.wforte.industrial.client.ter.DisplayCaseTileEntityRenderer;
import com.wforte.industrial.core.init.BlockInit;
import com.wforte.industrial.core.init.ContainerTypesInit;
import com.wforte.industrial.core.init.TileEntityTypesInit;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = IndustrialMod.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		ScreenManager.registerFactory(ContainerTypesInit.DISPLAY_CASE_CONTAINER_TYPE.get(), DisplayCaseScreen::new);
		
		RenderTypeLookup.setRenderLayer(BlockInit.EXAMPLE_LEAVES.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.EXAMPLE_SAPLING.get(), RenderType.getCutout());
		RenderTypeLookup.setRenderLayer(BlockInit.LAVENDER_BLOCK.get(), RenderType.getCutout());
		
		ClientRegistry.bindTileEntityRenderer(TileEntityTypesInit.DISPLAY_CASE_TILE_ENTITY_TYPE.get(), DisplayCaseTileEntityRenderer::new);
	}

}
