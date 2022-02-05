package com.wforte.industrial.entity.render;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.entity.custom.BuffZombieEntity;
import com.wforte.industrial.entity.custom.HogEntity;
import com.wforte.industrial.entity.model.BuffZombieModel;
import com.wforte.industrial.entity.model.HogModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HogModelRenderer extends MobRenderer<HogEntity, HogModel<HogEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(IndustrialMod.MOD_ID, "textures/entity/hog.png");

    public HogModelRenderer(EntityRendererManager manager) {
        super(manager, new HogModel<>(), 1f);
    }

    @Override
    public ResourceLocation getEntityTexture(HogEntity entity) {
        return TEXTURE;
    }
}
