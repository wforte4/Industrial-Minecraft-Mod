package com.wforte.industrial.core.init;



import com.wforte.industrial.IndustrialMod;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Dimension;

public class DimensionInit {
	
	public static final RegistryKey<Dimension> EXAMPLE_DIMENSION_WORLD = RegistryKey.getOrCreateKey(Registry.DIMENSION_KEY, new ResourceLocation(IndustrialMod.MOD_ID, "example_dimension"));

}
