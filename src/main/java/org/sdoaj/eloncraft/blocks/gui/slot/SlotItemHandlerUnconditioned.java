/*
 * This file ("SlotItemHandlerUnconditioned.java") is part of the Actually Additions mod for Minecraft.
 * It is created and owned by Ellpeck and distributed
 * under the Actually Additions License to be found at
 * http://ellpeck.de/actaddlicense
 * View the source code at https://github.com/Ellpeck/ActuallyAdditions
 *
 * © 2015-2017 Ellpeck
 */

package org.sdoaj.eloncraft.blocks.gui.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.SlotItemHandler;
import org.sdoaj.eloncraft.util.ItemStackHandler;

import javax.annotation.Nonnull;

public class SlotItemHandlerUnconditioned extends SlotItemHandler {
    private final ItemStackHandler inventory;
    private final int stackSizeLimit;

    private Runnable onSlotChanged;

    public SlotItemHandlerUnconditioned(ItemStackHandler inventory, int index, int xPosition, int yPosition, int stackSizeLimit) {
        super(inventory, index, xPosition, yPosition);
        this.inventory = inventory;
        this.stackSizeLimit = Math.min(stackSizeLimit, 64);
    }

    public SlotItemHandlerUnconditioned(ItemStackHandler inventory, int index, int xPosition, int yPosition) {
        this(inventory, index, xPosition, yPosition, 64);
    }

    public SlotItemHandlerUnconditioned setOnSlotChanged(Runnable onSlotChanged) {
        this.onSlotChanged = onSlotChanged;
        return this;
    }

    @Override
    public boolean isItemValid(ItemStack stack) {
        if (stack.isEmpty() || !this.inventory.canAccept(this.getSlotIndex(), stack, false)) return false;

        ItemStack currentStack = this.inventory.getStackInSlot(this.getSlotIndex());
        this.inventory.setStackInSlot(this.getSlotIndex(), ItemStack.EMPTY);
        ItemStack remainder = this.inventory.insertItem(this.getSlotIndex(), stack, true, false);
        this.inventory.setStackInSlot(this.getSlotIndex(), currentStack);
        return remainder.isEmpty() || remainder.getCount() < stack.getCount();
    }

    /**
     * Helper fnct to get the stack in the slot.
     */
    @Override
    @Nonnull
    public ItemStack getStack() {
        return this.inventory.getStackInSlot(this.getSlotIndex());
    }

    @Override
    public void putStack(ItemStack stack) {
        this.inventory.setStackInSlot(this.getSlotIndex(), stack);
        this.onSlotChanged();
    }

    @Override
    public int getSlotStackLimit() {
        return stackSizeLimit;
    }

    @Override
    public int getItemStackLimit(ItemStack stack) {
        ItemStack maxAdd = stack.copy();
        maxAdd.setCount(getSlotStackLimit());
        ItemStack currentStack = this.inventory.getStackInSlot(this.getSlotIndex());
        this.inventory.setStackInSlot(this.getSlotIndex(), ItemStack.EMPTY);
        ItemStack remainder = this.inventory.insertItem(this.getSlotIndex(), maxAdd, true, false);
        this.inventory.setStackInSlot(this.getSlotIndex(), currentStack);
        return getSlotStackLimit() - remainder.getCount();
    }

    @Override
    public boolean canTakeStack(EntityPlayer playerIn) {
        return !this.inventory.extractItem(this.getSlotIndex(), 1, true, false).isEmpty();
    }

    @Override
    public ItemStack decrStackSize(int amount) {
        return this.inventory.extractItem(this.getSlotIndex(), amount, false, false);
    }

    private ItemStack lastStack;

    // only does stuff when item in slot becomes different (may change if necessary)
    @Override
    public void onSlotChanged() {
        if (lastStack == null) {
            lastStack = this.getStack();
        } else {
            if (this.getStack().isItemEqual(lastStack)) {
                return;
            }

            lastStack = this.getStack();
        }

        if (onSlotChanged != null) {
            onSlotChanged.run();
        }

        super.onSlotChanged();
    }
}