package net.ingeniousmc.uraniumtech.entity.custom.gpu_fan;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.ingeniousmc.uraniumtech.UraniumTechNoblade;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GPUFanRenderer extends GeoEntityRenderer<GPUFanEntity> {
    public GPUFanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GPUFanModel());
        this.shadowRadius=2f;
    }

    @Override
    public ResourceLocation getTextureLocation(GPUFanEntity instance) {
        return new ResourceLocation(UraniumTechNoblade.MOD_ID, "textures/entity/gpu_fan/gpu_fan_entity.png");
    }

    @Override
    public RenderType getRenderType(GPUFanEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(0.8F, 0.8F, 0.8F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}

