package net.ingeniousmc.uraniumtech.entity.custom.gpu_fan;

import net.ingeniousmc.uraniumtech.UraniumTechNoblade;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static net.ingeniousmc.uraniumtech.entity.custom.gpu_fan.GPUFanRenderer.LOCATION_BY_VARIANT;

public class GPUFanModel extends AnimatedGeoModel<GPUFanEntity> {
    @Override
    public ResourceLocation getModelLocation(GPUFanEntity object) {
        return new ResourceLocation(UraniumTechNoblade.MOD_ID, "geo/gpu_fan_entity.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GPUFanEntity object) {
        return GPUFanRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GPUFanEntity animatable) {
        return new ResourceLocation(UraniumTechNoblade.MOD_ID, "animations/gpu_fan_entity.animation.json");
    }
}
