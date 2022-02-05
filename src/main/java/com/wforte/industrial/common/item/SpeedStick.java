package com.wforte.industrial.common.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import java.util.Objects;

public class SpeedStick extends Item {

    public SpeedStick(Properties properties) {
        super(properties);
    }

//    @Override
//    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
//        World world = context.getWorld();
//
//        if(!world.isRemote) {
//            PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());
//            BlockState clickedBlock = world.getBlockState(context.getPos());
//
//            playerEntity.addPotionEffect(new EffectInstance(Effects.SPEED, 200));
//            stack.damageItem(1, playerEntity, player -> player.sendBreakAnimation(context.getHand()));
//        }
//
//        return super.onItemUseFirst(stack, context);
//    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        if(!worldIn.isRemote) {
            this.damageItem(playerIn.getHeldItem(handIn), 1, playerIn, player -> player.sendBreakAnimation(handIn));
            playerIn.addPotionEffect(new EffectInstance(Effects.SPEED, 200));
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
