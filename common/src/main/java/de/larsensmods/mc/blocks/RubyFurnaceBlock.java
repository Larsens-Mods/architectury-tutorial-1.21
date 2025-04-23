package de.larsensmods.mc.blocks;

import com.mojang.serialization.MapCodec;
import de.larsensmods.mc.blocks.entities.RubyFurnaceEntity;
import de.larsensmods.mc.blocks.entities.TutorialModBlockEntityTypes;
import dev.architectury.event.events.common.InteractionEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RubyFurnaceBlock extends AbstractFurnaceBlock implements InteractionEvent.RightClickBlock {

    public static final MapCodec<RubyFurnaceBlock> CODEC = simpleCodec(RubyFurnaceBlock::new);

    @Override
    protected @NotNull MapCodec<? extends AbstractFurnaceBlock> codec() {
        return CODEC;
    }

    protected RubyFurnaceBlock(Properties properties) {
        super(properties);

        InteractionEvent.RIGHT_CLICK_BLOCK.register(this);
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof AbstractFurnaceBlockEntity) {
            player.openMenu((MenuProvider)blockEntity);
            player.awardStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return createFurnaceTicker(level, blockEntityType, TutorialModBlockEntityTypes.RUBY_FURNACE.get());
    }

    @Override
    public InteractionResult click(Player player, InteractionHand interactionHand, BlockPos blockPos, Direction direction) {
        if(player.level().getBlockEntity(blockPos) == null || !(player.level().getBlockEntity(blockPos) instanceof RubyFurnaceEntity blockEntity)){
            return InteractionResult.PASS;
        }
        if(player.isShiftKeyDown()){
            return InteractionResult.PASS;
        }

        player.openMenu(blockEntity);

        return InteractionResult.SUCCESS;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new RubyFurnaceEntity(pos, state);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (state.getValue(LIT)) {
            double d = (double)pos.getX() + (double)0.5F;
            double e = pos.getY();
            double f = (double)pos.getZ() + (double)0.5F;
            if (random.nextDouble() < 0.1) {
                level.playLocalSound(d, e, f, SoundEvents.FURNACE_FIRE_CRACKLE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            }

            Direction direction = state.getValue(FACING);
            Direction.Axis axis = direction.getAxis();
            double g = 0.52;
            double h = random.nextDouble() * 0.6 - 0.3;
            double i = axis == Direction.Axis.X ? (double)direction.getStepX() * 0.52 : h;
            double j = random.nextDouble() * (double)6.0F / (double)16.0F;
            double k = axis == Direction.Axis.Z ? (double)direction.getStepZ() * 0.52 : h;
            level.addParticle(ParticleTypes.SMOKE, d + i, e + j, f + k, (double)0.0F, (double)0.0F, (double)0.0F);
            level.addParticle(ParticleTypes.FLAME, d + i, e + j, f + k, (double)0.0F, (double)0.0F, (double)0.0F);
        }
    }
}
