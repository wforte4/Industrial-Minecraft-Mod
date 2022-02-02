package com.wforte.industrial.core.init;

import com.google.common.base.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialInit implements IItemTier {


	RUBY_TOOL(4, 1200, 7.0f, 3.0f, 10, () -> Ingredient.fromItems(ItemInit.RUBY.get())),
	TUNGSTEN_TOOL(5, 2000, 10.0F, 5.0F, 20, () -> Ingredient.fromItems(ItemInit.TUNGSTEN_SHARD.get()));
	
	private final int level;
	private final int uses;
	private final float speed;
	private final float damage;
	private final int enchantibility;
	private final Ingredient repairMaterial;
	
	ToolMaterialInit(int level, int uses, float speed, float damage, int enchantibility, Supplier<Ingredient> repairMaterial) {
		this.level = level;
		this.uses = uses;
		this.speed = speed;
		this.damage = damage;
		this.enchantibility = enchantibility;
		this.repairMaterial = repairMaterial.get();
	}

	@Override
	public int getMaxUses() {
		return this.uses;
	}

	@Override
	public float getEfficiency() {
		return this.speed;
	}

	@Override
	public float getAttackDamage() {
		return this.damage;
	}

	@Override
	public int getHarvestLevel() {
		return this.level;
	}

	@Override
	public int getEnchantability() {
		return this.enchantibility;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return repairMaterial;
	}

	public int getLevel() {
		return level;
	}

	public int getUses() {
		return uses;
	}

	public float getSpeed() {
		return speed;
	}

	public float getDamage() {
		return damage;
	}

	public int getEnchantibility() {
		return enchantibility;
	}

}
