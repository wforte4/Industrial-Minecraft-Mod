package com.wforte.industrial.core.init;

import com.google.common.base.Supplier;
import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.common.block.DisplayCaseBlock;
import com.wforte.industrial.common.block.LavenderCropBlock;
import com.wforte.industrial.common.block.trees.LavenderTree;
import com.wforte.industrial.core.itemgroup.ModGroup;

import net.minecraft.block.*;
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

	public static final RegistryObject<Block> LAVENDER_LOG = registerBlock("lavender_log",
			() -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD)
					.hardnessAndResistance(2f, 10f).harvestLevel(0).harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> LAVENDER_STRIPPED_LOG = registerBlock("lavender_stripped_log",
			() -> new RotatedPillarBlock(AbstractBlock.Properties.create(Material.WOOD).sound(SoundType.WOOD)
					.hardnessAndResistance(2f, 3f).harvestLevel(0).harvestTool(ToolType.AXE)));
	public static final RegistryObject<Block> LAVENDER_LEAVES = registerBlock("lavender_leaves",
			() -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).sound(SoundType.PLANT)
					.hardnessAndResistance(.2f, 1f).tickRandomly().notSolid()));
	public static final RegistryObject<Block> LAVENDER_SAPLING = registerBlock("lavender_sapling",
			() -> new SaplingBlock(new LavenderTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));
	public static final RegistryObject<Block> LAVENDER_PLANKS = registerBlock("lavender_planks",
			() -> new Block(AbstractBlock.Properties.create(Material.WOOD)
					.hardnessAndResistance(4f).sound(SoundType.WOOD)));

	// ORE Blocks
	public static final RegistryObject<Block> TUNGSTEN_ORE = registerBlock("tungsten_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(7f, 7f).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(3f, 3f).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));
	public static final RegistryObject<Block> RAINBOW_ORE = registerBlock("rainbow_ore",
			() -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.GRAY)
					.hardnessAndResistance(3f, 3f).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

	// Custom Blocks
	public static final RegistryObject<Block> DISPLAY_CASE = registerBlock("display_case",
			() -> new DisplayCaseBlock());
	public static final RegistryObject<Block> LAVENDER_BLOCK = BLOCKS.register("lavender_crop",
			() -> new LavenderCropBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));

	// Register a Block and then call register Block Item to also make an item in inventory for this to place
	private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn);
		return toReturn;
	}
	
	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
		ItemInit.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
		
	}

}
