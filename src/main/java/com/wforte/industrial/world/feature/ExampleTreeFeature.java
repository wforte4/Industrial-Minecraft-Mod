package com.wforte.industrial.world.feature;

import java.util.Random;

import com.mojang.serialization.Codec;
import com.wforte.industrial.core.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class ExampleTreeFeature extends Feature<NoFeatureConfig> {
	
	private static final Direction[] DIRECTIONS = new Direction[] { Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST };
	
	private static final BlockState LOG = BlockInit.EXAMPLE_LOG.get().getDefaultState();
	private static final BlockState LEAVES = BlockInit.EXAMPLE_LEAVES.get().getDefaultState().with(LeavesBlock.DISTANCE, 1);

	public ExampleTreeFeature(Codec<NoFeatureConfig> codec) {
		super(codec);
	}
	
	public boolean isAirOrLeaves(IWorldGenerationBaseReader reader, BlockPos pos) {
		if(!(reader instanceof IWorldReader)) {
			return reader.hasBlockState(pos, state -> state.isAir() || state.isIn(BlockTags.LEAVES));
		} else {
			return reader.hasBlockState(pos, state -> state.canBeReplacedByLeaves((IWorldReader) reader, pos));
		}
	}

	@Override
	public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos,
			NoFeatureConfig config) {
		
		while (pos.getY() > 1 && isAirOrLeaves(reader, pos)) {
			pos = pos.down();
		}
		
		// Trunks
		int minHeight = 4;
		int maxHeight = 7;
		int height = minHeight + rand.nextInt(maxHeight - minHeight);
		if (pos.getY() >= 1 && pos.getY() + maxHeight + 1 < reader.getHeight()) {
			for (int i = pos.getY() + 1; i < pos.getY() + height + 1; i++) {
				reader.setBlockState(new BlockPos(pos.getX(), i, pos.getZ()), LOG, 3);
			}
		} else {
			return false;
		}
		
		// Leaves
		
		for (int i = 1; i < 3; i++) {
			for (Direction d: DIRECTIONS) {
				reader.setBlockState(new BlockPos(pos.getX(), pos.getY() + height - i, pos.getZ()).offset(d, i), LEAVES, 3);
			}
		}
		
// Check if we are on dirt or not
//		if(!isDirtAt(reader, pos)) {
//			return false;
//		}
		
		return true;
	}

}
