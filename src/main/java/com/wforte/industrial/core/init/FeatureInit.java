package com.wforte.industrial.core.init;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.world.feature.ExampleTreeFeature;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FeatureInit {
	
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, IndustrialMod.MOD_ID);
	
	public static final RegistryObject<ExampleTreeFeature> EXAMPLE_TREE = FEATURES.register("example_tree", () -> new ExampleTreeFeature(NoFeatureConfig.field_236558_a_));

}
