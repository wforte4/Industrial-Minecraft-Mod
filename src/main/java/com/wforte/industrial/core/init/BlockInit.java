package com.wforte.industrial.core.init;

import com.google.common.base.Supplier;
import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.common.block.DisplayCaseBlock;
import com.wforte.industrial.common.block.IndustrialSaplingBlock;
import com.wforte.industrial.common.block.LavenderCropBlock;
import com.wforte.industrial.core.itemgroup.IndustrialModItemGroup;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GrassBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			IndustrialMod.MOD_ID);

	// Normal Blocks
	public static final RegistryObject<Block> YELLOW_GRASS = registerBlock("yellow_grass",
			() -> new GrassBlock(AbstractBlock.Properties.create(Material.EARTH, MaterialColor.GRASS)
					.hardnessAndResistance(4f).sound(SoundType.GROUND)));
	public static final RegistryObject<Block> YELLOW_DIRT = registerBlock("yellow_dirt",
			() -> new Block(AbstractBlock.Properties.create(Material.EARTH, MaterialColor.GRASS)
					.hardnessAndResistance(4f).sound(SoundType.GROUND)));

	public static final RegistryObject<Block> EXAMPLE_LOG = registerBlock("example_log",
			() -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD)
					.hardnessAndResistance(2f, 10f).harvestLevel(0).harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> EXAMPLE_STRIPPED_LOG = registerBlock("example_stripped_log",
			() -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD)
					.hardnessAndResistance(2f, 3f).harvestLevel(0).harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> EXAMPLE_LEAVES = registerBlock("example_leaves",
			() -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).sound(SoundType.PLANT)
					.hardnessAndResistance(.2f, 1f).tickRandomly().notSolid()));
	public static final RegistryObject<Block> EXAMPLE_SAPLING = registerBlock("example_sapling",
			() -> new IndustrialSaplingBlock(AbstractBlock.Properties.create(Material.LEAVES).sound(SoundType.PLANT)
					.hardnessAndResistance(0f).tickRandomly().notSolid(), null));

	// ORE Blocks
	public static final RegistryObject<Block> TUNGSTEN_ORE = registerBlock("tungsten_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(7f, 7f).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	// Custom Blocks
	public static final RegistryObject<Block> DISPLAY_CASE = registerBlock("display_case",
			() -> new DisplayCaseBlock());
	public static final RegistryObject<Block> LAVENDER_BLOCK = BLOCKS.register("lavender_crop",
			() -> new LavenderCropBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));
	
	private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
		
	}

}
