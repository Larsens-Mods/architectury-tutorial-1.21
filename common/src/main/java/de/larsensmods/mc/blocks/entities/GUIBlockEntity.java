package de.larsensmods.mc.blocks.entities;

import de.larsensmods.mc.ui.GUIBlockMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;

public class GUIBlockEntity extends BaseContainerBlockEntity {

    public static final int INVENTORY_SIZE = 2;

    private int storedBuckets = 0;

    private NonNullList<ItemStack> items;
    private ContainerData data;

    public GUIBlockEntity(BlockPos pos, BlockState state) {
        super(TutorialModBlockEntityTypes.GUI_BLOCK.get(), pos, state);

        this.items = NonNullList.withSize(INVENTORY_SIZE, ItemStack.EMPTY);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                if(index == 0) return storedBuckets;
                return -1;
            }

            @Override
            public void set(int index, int value) {
                if(index == 0) storedBuckets = value;
            }

            @Override
            public int getCount() {
                return 1;
            }
        };
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.tutorial_mod.gui_block");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new GUIBlockMenu(containerId, inventory, this, this.data);
    }

    @Override
    public int getContainerSize() {
        return INVENTORY_SIZE;
    }

    public static class Ticker<T extends BlockEntity> implements BlockEntityTicker<T> {
        @Override
        public void tick(Level level, BlockPos blockPos, BlockState blockState, T blockEntity) {
            if (blockEntity instanceof GUIBlockEntity guiBlockEntity) {
                ItemStack firstSlot = guiBlockEntity.getItem(0);
                if(firstSlot.is(Items.WATER_BUCKET)) {
                    if(guiBlockEntity.storedBuckets < 64) {
                        guiBlockEntity.storedBuckets++;
                        guiBlockEntity.setItem(0, new ItemStack(Items.BUCKET));
                    }
                }
                ItemStack secondSlot = guiBlockEntity.getItem(1);
                if(secondSlot.is(Items.BUCKET)) {
                    if(guiBlockEntity.storedBuckets > 0) {
                        guiBlockEntity.storedBuckets--;
                        guiBlockEntity.setItem(1, new ItemStack(Items.WATER_BUCKET));
                    }
                }
            }
        }
    }

}
