package com.wforte.industrial.common.world.surface;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.wforte.industrial.core.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ExampleSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	
	public static final BlockState YELLOW_GRASS = BlockInit.YELLOW_GRASS.get().getDefaultState();
	public static final BlockState YELLOW_DIRT = BlockInit.YELLOW_DIRT.get().getDefaultState();
	public static final BlockState STONE = Blocks.STONE.getDefaultState();
	
	public static final SurfaceBuilderConfig YELLOW_CONFIG = new SurfaceBuilderConfig(YELLOW_GRASS, YELLOW_DIRT, YELLOW_DIRT);
	public static final SurfaceBuilderConfig STONE_CONFIG = new SurfaceBuilderConfig(STONE, STONE, STONE);

	public ExampleSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
		super(codec);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, YELLOW_CONFIG);
		
	}

}
