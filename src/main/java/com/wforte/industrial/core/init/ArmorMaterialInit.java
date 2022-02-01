package com.wforte.industrial.core.init;

import java.util.function.Supplier;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public enum ArmorMaterialInit implements IArmorMaterial {

	TUNGSTEN_ARMOR("tungsten", 10, new int[] { 4, 7, 9, 4 }, 17, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4f, 0.2f, () -> Ingredient.fromItems(ItemInit.TUNGSTEN_SHARD.get())),;

	private static final int[] baseDurability = { 128, 144, 160, 112 };
	private final String name;
	private final int durabilityMultiplier;
	private final int[] armorVal;
	private final int enchantability;
	private final SoundEvent equipSound;
	private final float toughness;
	private final float knockbackResistance;
	private Ingredient repairIngredient;

	ArmorMaterialInit(String name, int durabilityMulitiplier, int[] armorVal, int enchantibility, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
		this.name = name;
		this.durabilityMultiplier = durabilityMulitiplier;
		this.armorVal = armorVal;
		this.enchantability = enchantibility;
		this.equipSound = equipSound;
		this.toughness = toughness;
		this.knockbackResistance = knockbackResistance;
		this.setRepairIngredient(repairIngredient.get());
	}


	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockbackResistance;
	}


	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return baseDurability[slotIn.getIndex()] * this.durabilityMultiplier;
	}


	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.armorVal[slotIn.getIndex()];
	}


	@Override
	public int getEnchantability() {
		return this.enchantability;
	}


	@Override
	public SoundEvent getSoundEvent() {
		return null;
	}


	@Override
	public Ingredient getRepairMaterial() {
		return this.repairIngredient;
	}


	public int getDurabilityMultiplier() {
		return durabilityMultiplier;
	}


	public int[] getArmorVal() {
		return armorVal;
	}


	public SoundEvent getEquipSound() {
		return equipSound;
	}


	public Ingredient getRepairIngredient() {
		return repairIngredient;
	}


	public void setRepairIngredient(Ingredient repairIngredient) {
		this.repairIngredient = repairIngredient;
	}


	public static int[] getBasedurability() {
		return baseDurability;
	}

}