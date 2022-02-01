package com.wforte.industrial.core.init;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.core.itemgroup.IndustrialModItemGroup;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			IndustrialMod.MOD_ID);

	// Regular Items
	public static final RegistryObject<Item> TUNGSTEN_SHARD = ITEMS.register("tungsten_shard",
			() -> new Item(new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
	public static final RegistryObject<Item> TUNGSTEN_JEWEL = ITEMS.register("tungsten_jewel",
			() -> new Item(new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
	public static final RegistryObject<Item> OBSIDIAN_STICK = ITEMS.register("obsidian_stick",
			() -> new Item(new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
	
	public static final RegistryObject<Item> LAVENDER = ITEMS.register("lavender",
			() -> new BlockItem(BlockInit.LAVENDER_BLOCK.get(), new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD).food(new Food.Builder().hunger(1).fastToEat().saturation(0.1f).build())));

	// Tools
	public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword",
			() -> new SwordItem(ToolMaterialInit.TUNGSTEN_TOOL, 5, 2f,
					new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
	public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe",
			() -> new AxeItem(ToolMaterialInit.TUNGSTEN_TOOL, 5, 2f,
					new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
	public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe",
			() -> new PickaxeItem(ToolMaterialInit.TUNGSTEN_TOOL, 5, 2f,
					new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
	public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_shovel",
			() -> new ShovelItem(ToolMaterialInit.TUNGSTEN_TOOL, 5, -1f,
					new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
	public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe",
			() -> new HoeItem(ToolMaterialInit.TUNGSTEN_TOOL, 5, 2f,
					new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));

	// Armor
	public static final RegistryObject<Item> TUNGSTEN_HELMET = ITEMS.register("tungsten_helmet",
			() -> new ArmorItem(ArmorMaterialInit.TUNGSTEN_ARMOR, EquipmentSlotType.HEAD,
					new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
	public static final RegistryObject<Item> TUNGSTEN_CHESTPLATE = ITEMS.register("tungsten_chestplate",
			() -> new ArmorItem(ArmorMaterialInit.TUNGSTEN_ARMOR, EquipmentSlotType.CHEST,
					new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
	public static final RegistryObject<Item> TUNGSTEN_LEGGINGS = ITEMS.register("tungsten_leggings",
			() -> new ArmorItem(ArmorMaterialInit.TUNGSTEN_ARMOR, EquipmentSlotType.LEGS,
					new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));
	public static final RegistryObject<Item> TUNGSTEN_BOOTS = ITEMS.register("tungsten_boots",
			() -> new ArmorItem(ArmorMaterialInit.TUNGSTEN_ARMOR, EquipmentSlotType.FEET,
					new Item.Properties().group(IndustrialModItemGroup.INDUSTRIAL_MOD)));

}
