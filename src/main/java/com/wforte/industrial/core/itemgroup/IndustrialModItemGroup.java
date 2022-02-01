package com.wforte.industrial.core.itemgroup;

import com.wforte.industrial.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class IndustrialModItemGroup extends ItemGroup {
	
	public static final IndustrialModItemGroup INDUSTRIAL_MOD = new IndustrialModItemGroup(ItemGroup.GROUPS.length, "industrial");

	public IndustrialModItemGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemInit.TUNGSTEN_SHARD.get());
	}

}
