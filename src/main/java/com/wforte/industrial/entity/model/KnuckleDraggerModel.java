package com.wforte.industrial.entity.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.wforte.industrial.entity.custom.KnuckleDraggerEntity;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;


public class KnuckleDraggerModel <T extends KnuckleDraggerEntity> extends EntityModel<T> {
    private final ModelRenderer leftArm;
    private final ModelRenderer cube_r1;
    private final ModelRenderer rightArm;
    private final ModelRenderer cube_r2;
    private final ModelRenderer head;
    private final ModelRenderer cube_r3;
    private final ModelRenderer leftLeg;
    private final ModelRenderer cube_r4;
    private final ModelRenderer rightLeg;
    private final ModelRenderer cube_r5;
    private final ModelRenderer torso;
    private final ModelRenderer cube_r6;

    public KnuckleDraggerModel() {
        textureWidth = 64;
        textureHeight = 64;

        leftArm = new ModelRenderer(this);
        leftArm.setRotationPoint(-6.0F, 6.0F, -1.0F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(0.0F, 1.0F, 0.0F);
        leftArm.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.0F, -1.5708F, 0.0F);
        cube_r1.setTextureOffset(0, 22).addBox(-1.0F, -2.5F, -1.5F, 2.0F, 19.0F, 3.0F, 0.0F, false);

        rightArm = new ModelRenderer(this);
        rightArm.setRotationPoint(6.0F, 6.0F, -1.0F);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.0F, 1.0F, 0.0F);
        rightArm.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.0F, -1.5708F, 0.0F);
        cube_r2.setTextureOffset(10, 22).addBox(-1.0F, -2.5F, -1.5F, 2.0F, 19.0F, 3.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(-0.5F, 3.0F, -1.0F);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(0.0F, 0.0F, -2.0F);
        head.addChild(cube_r3);
        setRotationAngle(cube_r3, 0.0F, -1.5708F, 0.0F);
        cube_r3.setTextureOffset(18, 0).addBox(-2.5F, -4.5F, -2.5F, 5.0F, 5.0F, 5.0F, 0.0F, false);

        leftLeg = new ModelRenderer(this);
        leftLeg.setRotationPoint(2.0F, 15.0F, -1.5F);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
        leftLeg.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.0F, -1.5708F, 0.0F);
        cube_r4.setTextureOffset(20, 22).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 10.0F, 3.0F, 0.0F, false);

        rightLeg = new ModelRenderer(this);
        rightLeg.setRotationPoint(-2.0F, 15.0F, -1.5F);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(0.0F, 0.0F, 0.0F);
        rightLeg.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.0F, -1.5708F, 0.0F);
        cube_r5.setTextureOffset(28, 10).addBox(-1.0F, -1.0F, -1.5F, 2.0F, 10.0F, 3.0F, 0.0F, false);

        torso = new ModelRenderer(this);
        torso.setRotationPoint(0.0F, 9.0F, -1.0F);


        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
        torso.addChild(cube_r6);
        setRotationAngle(cube_r6, 0.0F, -1.5708F, 0.0F);
        cube_r6.setTextureOffset(0, 0).addBox(-2.0F, -6.0F, -5.0F, 4.0F, 12.0F, 10.0F, 0.0F, false);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        leftArm.render(matrixStack, buffer, packedLight, packedOverlay);
        rightArm.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        leftLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        rightLeg.render(matrixStack, buffer, packedLight, packedOverlay);
        torso.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    @Override
    public void setRotationAngles(KnuckleDraggerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){

        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.rightLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftLeg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * .2F * limbSwingAmount;
        this.leftArm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * .2F * limbSwingAmount;
    }
}
