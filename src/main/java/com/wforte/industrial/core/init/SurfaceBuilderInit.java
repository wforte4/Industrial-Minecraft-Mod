package com.wforte.industrial.core.init;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.common.world.surface.ExampleSurfaceBuilder;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderInit {
	
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, IndustrialMod.MOD_ID);
	
	public static final RegistryObject<ExampleSurfaceBuilder> EXAMPLE_SURFACE_BUILDER = SURFACE_BUILDERS.register("example", () -> new ExampleSurfaceBuilder(SurfaceBuilderConfig.field_237203_a_));

}
