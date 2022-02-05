package com.wforte.industrial.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.wforte.industrial.entity.custom.HogEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class HogModel <T extends HogEntity> extends EntityModel<T> {

    private final ModelRenderer body;
    private final ModelRenderer rotation;
    private final ModelRenderer body_sub_1;
    private final ModelRenderer head;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer tusk;
    private final ModelRenderer tusk2;

    public HogModel() {
        textureWidth = 64;
        textureHeight = 32;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 11.0F, 2.0F);


        rotation = new ModelRenderer(this);
        rotation.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addChild(rotation);


        body_sub_1 = new ModelRenderer(this);
        body_sub_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        rotation.addChild(body_sub_1);
        body_sub_1.setTextureOffset(28, 8).addBox(-5.0F, -10.0F, -7.0F, 10.0F, 16.0F, 8.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 12.0F, -6.0F);
        head.setTextureOffset(26, 1).addBox(-4.0F, 2.0F, -11.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(26, 1).addBox(3.0F, 2.0F, -11.0F, 1.0F, 1.0F, 4.0F, 0.0F, false);
        head.setTextureOffset(0, 0).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
        head.setTextureOffset(16, 16).addBox(-2.0F, 0.0F, -9.0F, 4.0F, 3.0F, 1.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(-3.0F, 18.0F, 7.0F);
        leg1.setTextureOffset(0, 16).addBox(4.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(3.0F, 18.0F, 7.0F);
        leg2.setTextureOffset(0, 16).addBox(-8.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(-3.0F, 18.0F, -5.0F);
        leg3.setTextureOffset(0, 16).addBox(4.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(3.0F, 18.0F, -5.0F);
        leg4.setTextureOffset(0, 16).addBox(-8.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, 0.0F, false);

        tusk = new ModelRenderer(this);
        tusk.setRotationPoint(0.0F, 24.0F, 0.0F);


        tusk2 = new ModelRenderer(this);
        tusk2.setRotationPoint(0.0F, 24.0F, 0.0F);

    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch) {

        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        leg1.render(matrixStack, buffer, packedLight, packedOverlay);
        leg2.render(matrixStack, buffer, packedLight, packedOverlay);
        leg3.render(matrixStack, buffer, packedLight, packedOverlay);
        leg4.render(matrixStack, buffer, packedLight, packedOverlay);
        tusk.render(matrixStack, buffer, packedLight, packedOverlay);
        tusk2.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
