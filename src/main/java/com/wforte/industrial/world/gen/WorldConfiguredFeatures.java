package com.wforte.industrial.world.gen;

import com.wforte.industrial.core.init.BlockInit;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class WorldConfiguredFeatures {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> LAVENDER = register("lavender_tree",
            Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(BlockInit.LAVENDER_LOG.get().getDefaultState()),
                    new SimpleBlockStateProvider(BlockInit.LAVENDER_LEAVES.get().getDefaultState()),
                    new BlobFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 3),
                    new StraightTrunkPlacer(6, 2, 3),
                    new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }

}
