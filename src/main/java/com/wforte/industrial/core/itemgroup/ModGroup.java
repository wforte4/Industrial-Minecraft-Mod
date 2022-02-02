package com.wforte.industrial.core.itemgroup;

import com.wforte.industrial.core.init.ItemInit;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModGroup extends ItemGroup {
	
	public static final ModGroup INDUSTRIAL_MOD = new ModGroup(ItemGroup.GROUPS.length, "industrial");

	public ModGroup(int index, String label) {
		super(index, label);
	}

	@Override
	public ItemStack createIcon() {
		return new ItemStack(ItemInit.TUNGSTEN_SHARD.get());
	}

}
