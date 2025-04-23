package de.larsensmods.mc.blocks.entities;

import de.larsensmods.mc.recipe.TutorialModRecipeType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RubyFurnaceEntity extends AbstractFurnaceBlockEntity {

    public RubyFurnaceEntity(BlockPos pos, BlockState blockState) {
        super(TutorialModBlockEntityTypes.RUBY_FURNACE.get(), pos, blockState, TutorialModRecipeType.RUBY_SMELTING.get());
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.tutorial_mod.ruby_furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new FurnaceMenu(containerId, inventory, this, this.dataAccess);
    }
}
