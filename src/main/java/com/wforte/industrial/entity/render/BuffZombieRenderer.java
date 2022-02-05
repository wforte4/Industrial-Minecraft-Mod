package com.wforte.industrial.entity.render;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.entity.custom.BuffZombieEntity;
import com.wforte.industrial.entity.model.BuffZombieModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BuffZombieRenderer extends MobRenderer<BuffZombieEntity, BuffZombieModel<BuffZombieEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(IndustrialMod.MOD_ID, "textures/entity/buff_zombie.png");

    public BuffZombieRenderer(EntityRendererManager manager) {
        super(manager, new BuffZombieModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(BuffZombieEntity entity) {
        return TEXTURE;
    }
}
