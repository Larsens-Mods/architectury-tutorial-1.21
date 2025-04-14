package de.larsensmods.mc.blocks.entities;

import de.larsensmods.mc.TutorialMod;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

public class RubyCrateEntity extends BlockEntity {

    public RubyCrateEntity(BlockPos pos, BlockState state) {
        super(TutorialModBlockEntityTypes.RUBY_CRATE.get(), pos, state);
    }

    public static class Ticker<T extends BlockEntity> implements BlockEntityTicker<T> {
        @Override
        public void tick(Level level, BlockPos blockPos, BlockState blockState, T blockEntity) {
            TutorialMod.LOGGER.info("Ticker at " + blockPos.toShortString() + " with state " + blockState.toString() + " and entity type " + blockEntity.getClass().getName());
        }
    }

}
