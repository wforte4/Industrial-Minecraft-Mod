package com.wforte.industrial.world;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.world.gen.OreGeneration;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = IndustrialMod.MOD_ID)
public class WorldEvents {
	
	@SubscribeEvent
	public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
		OreGeneration.generateOres(event);
	}

}
