package com.wforte.industrial.core.init;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.common.item.ModSpawnEggItem;
import com.wforte.industrial.common.item.SpeedStick;
import com.wforte.industrial.core.itemgroup.ModGroup;

import com.wforte.industrial.entity.ModEntityTypes;
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
            () -> new Item(new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> TUNGSTEN_JEWEL = ITEMS.register("tungsten_jewel",
            () -> new Item(new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY_SHARD = ITEMS.register("ruby_shard",
            () -> new Item(new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> OBSIDIAN_STICK = ITEMS.register("obsidian_stick",
            () -> new Item(new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));

    public static final RegistryObject<Item> LAVENDER = ITEMS.register("lavender",
            () -> new BlockItem(BlockInit.LAVENDER_BLOCK.get(), new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));

    // Food

    // Spawn Eggs
    public static final RegistryObject<ModSpawnEggItem> BUFF_ZOMBIE_SPAWN_EGG = ITEMS.register("buff_zombie_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.BUFF_ZOMBIE, 0x464F56, 0x1D6336, new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<ModSpawnEggItem> KNUCKLE_DRAGGER_SPAWN_EGG = ITEMS.register("knuckle_dragger_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.KNUCKLE_DRAGGER, 0xbaa6fe, 0xff5774, new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<ModSpawnEggItem> HOG_SPAWN_EGG = ITEMS.register("hog_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.HOG, 0x693d15, 0x815329, new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));

    // Custom Items
    public static final RegistryObject<Item> SPEED_STICK = ITEMS.register("speed_stick", () -> new SpeedStick(new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));

    // Tools
    public static final RegistryObject<Item> TUNGSTEN_SWORD = ITEMS.register("tungsten_sword",
            () -> new SwordItem(ToolMaterialInit.TUNGSTEN_TOOL, 5, 2f,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> TUNGSTEN_AXE = ITEMS.register("tungsten_axe",
            () -> new AxeItem(ToolMaterialInit.TUNGSTEN_TOOL, 5, 2f,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> TUNGSTEN_PICKAXE = ITEMS.register("tungsten_pickaxe",
            () -> new PickaxeItem(ToolMaterialInit.TUNGSTEN_TOOL, 5, 2f,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> TUNGSTEN_SHOVEL = ITEMS.register("tungsten_shovel",
            () -> new ShovelItem(ToolMaterialInit.TUNGSTEN_TOOL, 5, -1f,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> TUNGSTEN_HOE = ITEMS.register("tungsten_hoe",
            () -> new HoeItem(ToolMaterialInit.TUNGSTEN_TOOL, 5, 2f,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ToolMaterialInit.RUBY_TOOL, 5, 2f,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ToolMaterialInit.RUBY_TOOL, 5, 2f,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ToolMaterialInit.RUBY_TOOL, 5, 2f,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ToolMaterialInit.RUBY_TOOL, 5, -1f,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ToolMaterialInit.RUBY_TOOL, 5, 2f,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));

    // Armor
    public static final RegistryObject<Item> TUNGSTEN_HELMET = ITEMS.register("tungsten_helmet",
            () -> new ArmorItem(ArmorMaterialInit.TUNGSTEN_ARMOR, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> TUNGSTEN_CHESTPLATE = ITEMS.register("tungsten_chestplate",
            () -> new ArmorItem(ArmorMaterialInit.TUNGSTEN_ARMOR, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> TUNGSTEN_LEGGINGS = ITEMS.register("tungsten_leggings",
            () -> new ArmorItem(ArmorMaterialInit.TUNGSTEN_ARMOR, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> TUNGSTEN_BOOTS = ITEMS.register("tungsten_boots",
            () -> new ArmorItem(ArmorMaterialInit.TUNGSTEN_ARMOR, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ArmorMaterialInit.RUBY_ARMOR, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ArmorMaterialInit.RUBY_ARMOR, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ArmorMaterialInit.RUBY_ARMOR, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ArmorMaterialInit.RUBY_ARMOR, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModGroup.INDUSTRIAL_MOD)));

}
