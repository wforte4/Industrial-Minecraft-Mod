package com.wforte.industrial.world;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.world.gen.ModEntityGeneration;
import com.wforte.industrial.world.gen.ModTreeGeneration;
import com.wforte.industrial.world.gen.OreGeneration;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IndustrialMod.MOD_ID)
public class WorldGenerationEvents {
	
	@SubscribeEvent
	public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
		ModTreeGeneration.generateTrees(event);
		OreGeneration.generateOres(event);
		ModEntityGeneration.onEntitySpawn(event);
	}

}
