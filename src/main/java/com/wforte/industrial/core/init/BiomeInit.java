package com.wforte.industrial.core.init;

import com.google.common.base.Supplier;
import com.wforte.industrial.IndustrialMod;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {
	
	public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, IndustrialMod.MOD_ID);
				
	static {
		createBiome("example_biome", BiomeMaker::makeVoidBiome);
		createBiome("aether_mountains", BiomeMaker::makeVoidBiome);
	}
	
	public static RegistryKey<Biome> EXAMPLE_BIOME = registerBiome("example_biome");
	public static RegistryKey<Biome> AETHER_MOUNTAINS = registerBiome("aether_mountains");
	
	public static RegistryKey<Biome> registerBiome(String biomeName) {
		return RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(IndustrialMod.MOD_ID, biomeName));
	}
	
	public static RegistryObject<Biome> createBiome(String biomeName, Supplier<Biome> biome) {
		return BIOMES.register(biomeName, biome);
	}
	
	public static void registerBiomes() {
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(EXAMPLE_BIOME, 10));
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(AETHER_MOUNTAINS, 2));
	}

}