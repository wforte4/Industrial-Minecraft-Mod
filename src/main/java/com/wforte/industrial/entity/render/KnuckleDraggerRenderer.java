package com.wforte.industrial.entity.render;

import com.wforte.industrial.IndustrialMod;
import com.wforte.industrial.entity.custom.BuffZombieEntity;
import com.wforte.industrial.entity.custom.KnuckleDraggerEntity;
import com.wforte.industrial.entity.model.BuffZombieModel;
import com.wforte.industrial.entity.model.KnuckleDraggerModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class KnuckleDraggerRenderer extends MobRenderer<KnuckleDraggerEntity, KnuckleDraggerModel<KnuckleDraggerEntity>> {

    protected static final ResourceLocation TEXTURE = new ResourceLocation(IndustrialMod.MOD_ID, "textures/entity/knuckle_dragger.png");

    public KnuckleDraggerRenderer(EntityRendererManager manager) {
        super(manager, new KnuckleDraggerModel<>(), 0.7f);
    }

    @Override
    public ResourceLocation getEntityTexture(KnuckleDraggerEntity entity) {
        return TEXTURE;
    }
}
