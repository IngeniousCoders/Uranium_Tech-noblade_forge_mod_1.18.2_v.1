package net.ingeniousmc.uraniumtech.entity.custom.gpu_fan;

import net.ingeniousmc.uraniumtech.entity.ModEntities;
import net.ingeniousmc.uraniumtech.entity.custom.gpu_fan.variants.GPUFanEntityVariant;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.function.Predicate;

public class GPUFanEntity extends Bat implements PlayerRideable,IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private int nextHeightOffsetChangeTick;
    private float allowedHeightOffset = 10.5F;

    private static final EntityDataAccessor<Boolean> IDLE =
            SynchedEntityData.defineId(GPUFanEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IDLE_FLYING =
            SynchedEntityData.defineId(GPUFanEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> POWERED_OFF =
            SynchedEntityData.defineId(GPUFanEntity.class, EntityDataSerializers.BOOLEAN);

    @javax.annotation.Nullable
    private BlockPos targetPosition;
    //entity stuff

    public GPUFanEntity(EntityType<? extends Bat> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes(){
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20000000)
                .add(Attributes.MOVEMENT_SPEED, 0.5)
                .add(Attributes.FLYING_SPEED, 1)
                .build();
    }
    protected void registerGoals(){

    }
    ////flying logic
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gpu_fan_entity.idle", true));
        if (event.isMoving()) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.gpu_fan_entity.spinning", true));
            return PlayState.CONTINUE;

        }

        return PlayState.CONTINUE;
    }
    public void aiStep() {
        super.aiStep();
    }
    protected void customServerAiStep() {
        --this.nextHeightOffsetChangeTick;
        if (this.nextHeightOffsetChangeTick <= 10) {
            this.nextHeightOffsetChangeTick = 100;
            this.allowedHeightOffset = 3F + (float)this.random.nextGaussian() * 3.0F;
        }
        super.customServerAiStep();
        }


    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.EVENTS;
    }


    ///variants logic
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        GPUFanEntityVariant variant = Util.getRandom(GPUFanEntityVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT =
            SynchedEntityData.defineId(GPUFanEntity.class, EntityDataSerializers.INT);

    public GPUFanEntityVariant getVariant() {
        return GPUFanEntityVariant.byId(this.getTypeVariant() & 255);
    }
    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }
    private void setVariant(GPUFanEntityVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag p_21815_) {
        super.readAdditionalSaveData(p_21815_);
        this.entityData.set(DATA_ID_TYPE_VARIANT, p_21815_.getInt("Variant"));
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putInt("Variant", this.getTypeVariant());
    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        this.entityData.define(POWERED_OFF, false);
        this.entityData.define(IDLE, false);
        this.entityData.define(IDLE_FLYING, true);
    }
    ///
    @Override
    public void registerControllers(AnimationData data) {
    }
    @Override
    public AnimationFactory getFactory() {
        return factory;
    }


}
