package net.ingeniousmc.uraniumtech.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;
public class TechnobladeOreBlock extends Block {
    public static final IntegerProperty TECHNO_STAGES = IntegerProperty.create("techno_stages", 0, 5);
    public TechnobladeOreBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TECHNO_STAGES, Integer.valueOf(0)));
    }
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide) {
            interact(pState, pLevel, pPos);
        }
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        return itemstack.getItem() instanceof BlockItem && (new BlockPlaceContext(pPlayer, pHand, itemstack, pHit)).canPlace() ? InteractionResult.PASS : InteractionResult.SUCCESS;
    }
    private static void spawnParticles(Level pLevel, BlockPos pPos) {
        double d0 = 0.5625D;
        Random random = pLevel.random;

        for(Direction direction : Direction.values()) {
            BlockPos blockpos = pPos.relative(direction);
            if (!pLevel.getBlockState(blockpos).isSolidRender(pLevel, blockpos)) {
                Direction.Axis direction$axis = direction.getAxis();
                double d1 = direction$axis == Direction.Axis.X ? 0.5D + 0.5625D * (double)direction.getStepX() : (double)random.nextFloat();
                double d2 = direction$axis == Direction.Axis.Y ? 0.5D + 0.5625D * (double)direction.getStepY() : (double)random.nextFloat();
                double d3 = direction$axis == Direction.Axis.Z ? 0.5D + 0.5625D * (double)direction.getStepZ() : (double)random.nextFloat();
                pLevel.addParticle(DustParticleOptions.REDSTONE, (double)pPos.getX() + d1, (double)pPos.getY() + d2, (double)pPos.getZ() + d3, 0.0D, 0.0D, 0.0D);
            }
        }

    }
    private static void interact(BlockState pState, Level pLevel, BlockPos pPos) {
        spawnParticles(pLevel, pPos);
        if (!(pState.getValue(TECHNO_STAGES) == 5)) {
            int i = pState.getValue(TECHNO_STAGES);
            if (i < 5) {
                pLevel.setBlock(pPos, pState.setValue(TECHNO_STAGES, Integer.valueOf(i + 1)), 3);
            }
        }
    }
    @Override
    @Deprecated
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, Random pRandom) {
        if (pState.getValue(TECHNO_STAGES) == 5) {
            interact(pState, pLevel, pPos);
        }

    }
    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return super.isRandomlyTicking(pState);
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(TECHNO_STAGES);
    }
}
