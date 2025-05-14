package de.larsensmods.mc.blocks;

import com.mojang.serialization.MapCodec;
import de.larsensmods.mc.blocks.entities.GUIBlockEntity;
import dev.architectury.event.events.common.InteractionEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

//IDENTICAL TO CRATE BLOCK SETUP
public class GUIBlock extends BaseEntityBlock implements InteractionEvent.RightClickBlock {

    public static final MapCodec<RubyCrateBlock> CODEC = simpleCodec(RubyCrateBlock::new);

    @Override
    protected @NotNull MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    protected GUIBlock(Properties properties) {
        super(properties);

        InteractionEvent.RIGHT_CLICK_BLOCK.register(this);
    }

    @Override
    public InteractionResult click(Player player, InteractionHand interactionHand, BlockPos blockPos, Direction direction) {
        if(player.level().getBlockEntity(blockPos) == null || !(player.level().getBlockEntity(blockPos) instanceof GUIBlockEntity blockEntity)){
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
        return new GUIBlockEntity(pos, state);
    }

    @Override
    public @Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        return new GUIBlockEntity.Ticker<>();
    }

}
