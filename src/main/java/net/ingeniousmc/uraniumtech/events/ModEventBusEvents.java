package net.ingeniousmc.uraniumtech.events;

import net.ingeniousmc.uraniumtech.UraniumTechNoblade;
import net.ingeniousmc.uraniumtech.entity.ModEntities;
import net.ingeniousmc.uraniumtech.entity.custom.gpu_fan.GPUFanEntity;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = UraniumTechNoblade.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GPU_FAN.get(), GPUFanEntity.setAttributes());

    }
}