package net.ingeniousmc.uraniumtech.entity;

import net.ingeniousmc.uraniumtech.UraniumTechNoblade;
import net.ingeniousmc.uraniumtech.entity.custom.gpu_fan.GPUFanEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, UraniumTechNoblade.MOD_ID);


    public static final RegistryObject<EntityType<GPUFanEntity>> GPU_FAN = ENTITY_TYPES.register("gpu_fan",
            () -> EntityType.Builder.of(GPUFanEntity::new, MobCategory.CREATURE)
                    .sized(5f, 1f).clientTrackingRange(100)
                    .build(new ResourceLocation(UraniumTechNoblade.MOD_ID, "gpu_fan").toString()));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
