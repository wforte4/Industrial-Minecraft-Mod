package com.wforte.industrial.world.gen;

import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.Dimension;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.BlockMatchRuleTest;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import java.util.Arrays;

public class OreGeneration {

	public static void generateOres(final BiomeLoadingEvent event) {
		spawnOreInAllBiomes(OreType.RUBY, event, Dimension.OVERWORLD);
		spawnOreInAllBiomes(OreType.TUNGSTEN, event, Dimension.OVERWORLD);
		spawnOreInAllBiomes(OreType.RAINBOW, event, Dimension.OVERWORLD);
	}

	private static ConfiguredFeature<?, ?> makeOreFeature(OreType oreType, RegistryKey<Dimension> dimensionToSpawnIn) {
		OreFeatureConfig oreFeatureConfig = null;

		if(dimensionToSpawnIn.toString().equals(Dimension.OVERWORLD.toString())) {
			oreFeatureConfig = getOverworldFeatureConfig(oreType);
		} else if(dimensionToSpawnIn.toString().equals(Dimension.THE_NETHER.toString())) {
			oreFeatureConfig = getNetherFeatureConfig(oreType);
		} else if(dimensionToSpawnIn.toString().equals(Dimension.THE_END.toString())) {
			oreFeatureConfig = getEndFeatureConfig(oreType);
		}

		ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = Placement.RANGE.configure(
				new TopSolidRangeConfig(oreType.getMinHeight(), oreType.getMinHeight(), oreType.getMaxHeight())
		);

		return registerOreFeature(oreType, oreFeatureConfig, configuredPlacement);
	}

	private static void spawnOreInOverworldInSpecificBiomes(OreType oreType, final BiomeLoadingEvent event, Biome... biomes) {
		OreFeatureConfig oreFeatureConfig = getOverworldFeatureConfig(oreType);
		ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = getConfig(oreType);
		ConfiguredFeature<?, ?> oreFeature = registerOreFeature(oreType, oreFeatureConfig, configuredPlacement);

		if(Arrays.stream(biomes).anyMatch(b -> b.getRegistryName().equals(event.getName()))) {
			event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
		}
	}

	private static void spawnOreInOverworldInAllBiomes(OreType oreType, final BiomeLoadingEvent event) {
		OreFeatureConfig oreFeatureConfig = getOverworldFeatureConfig(oreType);
		ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement = getConfig(oreType);
		ConfiguredFeature<?, ?> oreFeature = registerOreFeature(oreType, oreFeatureConfig, configuredPlacement);

		event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreFeature);
	}

	private static void spawnOreInSpecificBiome(OreType oreType, final BiomeLoadingEvent event, RegistryKey<Biome> biomeToSpawnIn, RegistryKey<Dimension> dimension) {
		if(event.getName().toString().contains(biomeToSpawnIn.getLocation().toString())) {
			event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, makeOreFeature(oreType, dimension));
		}
	}

	private static void spawnOreInAllBiomes(OreType currentOreType, final BiomeLoadingEvent event, RegistryKey<Dimension> dimension) {
		event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
				makeOreFeature(currentOreType, dimension));
	}

	private static ConfiguredPlacement<TopSolidRangeConfig> getConfig(OreType oreType) {
		return Placement.RANGE.configure(new TopSolidRangeConfig(oreType.getMinHeight(), oreType.getMinHeight(), oreType.getMaxHeight()));
	}

	private static ConfiguredFeature<?, ?> registerOreFeature(OreType oreType, OreFeatureConfig oreFeatureConfig,
			ConfiguredPlacement<TopSolidRangeConfig> configuredPlacement) {
		return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, oreType.getBlock().get().getRegistryName(),
				Feature.ORE.withConfiguration(oreFeatureConfig).withPlacement(configuredPlacement).square().func_242731_b(oreType.getMaxVeinPerChunk()));
	}

	private static OreFeatureConfig getOverworldFeatureConfig(OreType oreType) {
		return new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, oreType.getBlock().get().getDefaultState(), oreType.getMaxVeinSize());
	}

	private static OreFeatureConfig getNetherFeatureConfig(OreType oreType) {
		return new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NETHERRACK, oreType.getBlock().get().getDefaultState(), oreType.getMaxVeinSize());
	}

	private static OreFeatureConfig getEndFeatureConfig(OreType oreType) {
		return new OreFeatureConfig(new BlockMatchRuleTest(Blocks.END_STONE), oreType.getBlock().get().getDefaultState(), oreType.getMaxVeinSize());
	}

}
