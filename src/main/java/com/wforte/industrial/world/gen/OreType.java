package com.wforte.industrial.world.gen;

import com.wforte.industrial.core.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

	RUBY(Lazy.of(BlockInit.RUBY_ORE), 8, 16, 40, 4),
	RAINBOW(Lazy.of(BlockInit.RAINBOW_ORE), 6, 12, 30, 4),
	TUNGSTEN(Lazy.of(BlockInit.TUNGSTEN_ORE), 4, 0, 20, 3);

	private final Lazy<Block> block;
	private final int maxVeinSize;
	private final int minHeight;
	private final int maxHeight;
	private final int maxVeinPerChunk;

	OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight, int maxVeinPerChunk) {
		this.block = block;
		this.maxVeinSize = maxVeinSize;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.maxVeinPerChunk = maxVeinPerChunk;
	}

	public Lazy<Block> getBlock() {
		return block;
	}

	public int getMaxVeinSize() {
		return maxVeinSize;
	}

	public int getMinHeight() {
		return minHeight;
	}

	public int getMaxHeight() {
		return maxHeight;
	}

	public int getMaxVeinPerChunk() { return maxVeinPerChunk; }

	public static OreType get(Block block) {
		for (OreType ore : values()) {
			if (block == ore.block) {
				return ore;
			}
		}
		return null;
	}

}
