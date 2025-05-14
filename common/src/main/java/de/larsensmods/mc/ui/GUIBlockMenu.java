package de.larsensmods.mc.ui;

import de.larsensmods.mc.TutorialMod;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class GUIBlockMenu extends AbstractContainerMenu {

    public final Container container;
    public final ContainerData data;

    public GUIBlockMenu(int containerID, Inventory playerInventory) {
        this(containerID, playerInventory, new SimpleContainer(2), new SimpleContainerData(1));
    }

    public GUIBlockMenu(int containerID, Inventory playerInventory, Container container, ContainerData containerData) {
        super(TutorialModMenuTypes.GUI_BLOCK.get(), containerID);
        checkContainerSize(container, 2);
        checkContainerDataCount(containerData, 1);

        this.container = container;
        this.data = containerData;

        // Player inventory
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        // Player Hotbar
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        // Own slots
        this.addSlot(new Slot(container, 0, 62, 35));
        this.addSlot(new Slot(container, 1, 98, 35));

        this.addDataSlots(containerData);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if(slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();

            if (index < 36) {
                if (!moveItemStackTo(originalStack, 36, 36 + 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (index < 36 + 2) {
                if (!moveItemStackTo(originalStack, 0, 36, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                TutorialMod.LOGGER.error("Invalid slot index: {}", index);
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            slot.onTake(player, originalStack);
        }
        return newStack;
    }

    @Override
    public boolean stillValid(Player player) {
        return container.stillValid(player);
    }
}
