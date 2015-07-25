package com.eagle.resonantreflux.container;

import com.eagle.resonantreflux.tileentities.function.TileEntityFluxCrystallizationChamber;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 25/07/2015, 15:01 GMT.
 */
public class ContainerFluxCrystallizationChamber extends Container
{
    protected TileEntityFluxCrystallizationChamber tileEntity;
    private InventoryPlayer inventoryPlayer;

    public ContainerFluxCrystallizationChamber(InventoryPlayer inventoryPlayer, TileEntityFluxCrystallizationChamber fluxCrystallizationChamber)
    {
        this.tileEntity = fluxCrystallizationChamber;
        this.inventoryPlayer = inventoryPlayer;

        addSlotToContainer(new Slot(tileEntity, 0, 134, 57));
        addSlotToContainer(new Slot(tileEntity, 1, 134, 17));
        addPlayerInventory(8, 84);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot)
    {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);

        if (slotObject != null && slotObject.getHasStack())
        {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            if (slot < tileEntity.getSizeInventory())
            {
                if (!this.mergeItemStack(stackInSlot, tileEntity.getSizeInventory(), 36+tileEntity.getSizeInventory(), true))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(stackInSlot, 0, tileEntity.getSizeInventory(), false))
            {
                return null;
            }

            if (stackInSlot.stackSize == 0)
            {
                slotObject.putStack(null);
            }
            else
            {
                slotObject.onSlotChanged();
            }

            if (stackInSlot.stackSize == stack.stackSize)
            {
                return null;
            }
            slotObject.onPickupFromSlot(player, stackInSlot);
        }
        return stack;
    }

    protected void addPlayerInventory(int x, int y)
    {
        if (inventoryPlayer != null)
        {
            for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex)
            {
                for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex)
                {
                    addSlotToContainer(new Slot(inventoryPlayer,
                            9 + inventoryColumnIndex + inventoryRowIndex * 9,
                            x + inventoryColumnIndex * 18, y + inventoryRowIndex * 18));
                }
            }
            for (int hotBarIndex = 0; hotBarIndex < 9; ++hotBarIndex)
            {
                addSlotToContainer(new Slot(inventoryPlayer, hotBarIndex, 8 + hotBarIndex * 18, y + 58));
            }
        }
    }
}
