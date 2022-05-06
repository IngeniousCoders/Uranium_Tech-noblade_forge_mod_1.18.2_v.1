package net.ingeniousmc.uraniumtech.entity.custom.gpu_fan;

import net.ingeniousmc.uraniumtech.UraniumTechNoblade;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GPUFanModel extends AnimatedGeoModel<GPUFanEntity> {
    @Override
    public ResourceLocation getModelLocation(GPUFanEntity object) {
        return new ResourceLocation(UraniumTechNoblade.MOD_ID, "geo/gpu_fan_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GPUFanEntity object) {
        return new ResourceLocation(UraniumTechNoblade.MOD_ID, "textures/entity/gpu_fan/gpu_fan_entity.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GPUFanEntity animatable) {
        return new ResourceLocation(UraniumTechNoblade.MOD_ID, "animations/gpu_fan_entitu.animation.json");
    }
}
