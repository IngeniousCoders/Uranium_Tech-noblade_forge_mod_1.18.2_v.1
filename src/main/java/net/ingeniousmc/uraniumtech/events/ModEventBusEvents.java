package net.ingeniousmc.uraniumtech.events;

import net.ingeniousmc.uraniumtech.UraniumTechNoblade;
import net.ingeniousmc.uraniumtech.entity.ModEntities;
import net.ingeniousmc.uraniumtech.entity.custom.gpu_fan.GPUFanEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = UraniumTechNoblade.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GPU_FAN.get(), GPUFanEntity.setAttributes());

    }
}