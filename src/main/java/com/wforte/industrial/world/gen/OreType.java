package com.wforte.industrial.world.gen;

import com.wforte.industrial.core.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

	TUNGSTEN(Lazy.of(BlockInit.TUNGSTEN_ORE), 4, 0, 20);

	private final Lazy<Block> block;
	private final int maxVeinSize;
	private final int minHeight;
	private final int maxHeight;

	OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight) {
		this.block = block;
		this.maxVeinSize = maxVeinSize;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
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

	public static OreType get(Block block) {
		for (OreType ore : values()) {
			if (block == ore.block) {
				return ore;
			}
		}
		return null;
	}

}