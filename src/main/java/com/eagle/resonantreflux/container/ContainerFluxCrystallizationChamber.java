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

        addSlotToContainer(new Slot(tileEntity, 0, 147, 56)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return stack != null && stack.getItem() != null &&
                        tileEntity.isItemValidForSlot(0, stack);
            }
        });

        addSlotToContainer(new Slot(tileEntity, 1, 147, 13)
        {
            @Override
            public boolean isItemValid(ItemStack stack)
            {
                return false;
            }
        });

        addPlayerInventory(8, 84);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slot)
    {
        return null;
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
