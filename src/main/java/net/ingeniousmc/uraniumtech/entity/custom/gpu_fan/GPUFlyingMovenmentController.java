package net.ingeniousmc.uraniumtech.entity.custom.gpu_fan;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;

public class GPUFlyingMovenmentController extends FlyingMoveControl {
    private final int maxTurn;
    private final boolean hoversInPlace;

    public GPUFlyingMovenmentController(Mob pMob, int pMaxTurn, boolean pHoversInPlace) {
        super(pMob, pMaxTurn, pHoversInPlace);
        this.maxTurn = pMaxTurn;
        this.hoversInPlace = pHoversInPlace;
    }

    @Override
    public void tick(){

    }
}
