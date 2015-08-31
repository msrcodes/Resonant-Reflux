package com.eagle.resonantreflux.tileentities.function;

import com.eagle.resonantreflux.networking.MessageProgress;
import com.eagle.resonantreflux.networking.PacketHandler;
import com.eagle.resonantreflux.registry.ItemRegistry;
import com.eagle.resonantreflux.tileentities.core.TileEntityRR;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 24/07/2015, 19:45 GMT.
 */
public class TileEntityFluxCrystallizationChamber extends TileEntityRR implements ISidedInventory
{
    private ItemStack[] inv = new ItemStack[2];
    private int progress, multiplier, multiplierDuration;

    public TileEntityFluxCrystallizationChamber()
    {
        super(40000000, 32000);
        progress = 0;
        multiplier = 1;
    }

    @Override
    public void updateEntity()
    {
        if (worldObj.isRemote)
        {
            return;
        }

        if (progress < 40000000 && canFunction())
        {
            storage.modifyEnergyStored(-2000);
            progress += 2000 * multiplier;

            if (multiplier > 1 && multiplierDuration > 0)
            {
                multiplierDuration--;
            }
            else
            {
                setMultiplier(1);
                consumeMultiplier();
            }

            if (worldObj.getWorldTime() % 20 == 0 || multiplierDuration > 0)
            {
                PacketHandler.INSTANCE.sendToAllAround(new MessageProgress(xCoord, yCoord, zCoord, progress, multiplier, multiplierDuration, storage.getEnergyStored(), storage.getMaxEnergyStored()), new NetworkRegistry.TargetPoint(worldObj.provider.dimensionId, xCoord, yCoord, zCoord, 64));
            }
        }
        else if (progress >= 40000000 && canFunction())
        {
            if (getStackInSlot(1) == null)
            {
                setInventorySlotContents(1, new ItemStack(ItemRegistry.fluxCrystal).copy());
                progress = 0;
            }
            else
            {
                getStackInSlot(1).stackSize++;
                progress = 0;
            }
        }

        worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
    }

    private boolean canFunction()
    {
        return storage.getEnergyStored() >= 2000 &&
                (getStackInSlot(1) == null || getStackInSlot(1).stackSize < getInventoryStackLimit());
    }

    private void calculateMultiplier()
    {
        if (this.getStackInSlot(0) == null)
        {
            setMultiplier(1);
            setMultiplierDuration(0);
        }
        if (this.getStackInSlot(0).getItem() == ItemRegistry.scrap)
        {
            setMultiplier(2);
            setMultiplierDuration(20);
        }
        else if (this.getStackInSlot(0).getItem() == ItemRegistry.scrapBag)
        {
            setMultiplier(18);
            setMultiplierDuration(20);
        }
    }

    private void consumeMultiplier()
    {
        if (this.getStackInSlot(0) == null)
        {
            return;
        }

        if (multiplierDuration == 0)
        {
            calculateMultiplier();

            if (this.getStackInSlot(0).stackSize >= 2)
            {
                this.getStackInSlot(0).stackSize--;
            }
            else if (this.getStackInSlot(0).stackSize == 1)
            {
                this.setInventorySlotContents(0, null);
            }
        }

    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound)
    {
        super.readFromNBT(tagCompound);
        progress = tagCompound.getInteger("Progress");
        multiplier = tagCompound.getInteger("Multiplier");
        multiplierDuration = tagCompound.getInteger("Multiplier_Duration");
        NBTTagList nbttaglist = tagCompound.getTagList("Items", 10);
        this.inv = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound tagCompound1 = nbttaglist.getCompoundTagAt(i);
            int j = tagCompound1.getByte("Slot") & 255;

            if (j >= 0 && j < this.inv.length)
            {
                this.inv[j] = ItemStack.loadItemStackFromNBT(tagCompound1);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound)
    {
        super.writeToNBT(tagCompound);
        tagCompound.setInteger("Progress", progress);
        tagCompound.setInteger("Multiplier", multiplier);
        tagCompound.setInteger("Multiplier_Duration", multiplierDuration);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.inv.length; ++i)
        {
            if (this.inv[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte) i);
                this.inv[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        tagCompound.setTag("Items", nbttaglist);
    }

    public int getProgress()
    {
        return progress;
    }

    public void setProgress(int progress)
    {
        this.progress = progress;
    }

    public int getMultiplier()
    {
        return multiplier;
    }

    public void setMultiplier(int multiplier)
    {
        this.multiplier = multiplier;
    }

    public int getMultiplierDuration()
    {
        return multiplierDuration;
    }

    public void setMultiplierDuration(int multiplierDuration)
    {
        this.multiplierDuration = multiplierDuration;
    }

    public int getPowerStored()
    {
        return this.storage.getEnergyStored();
    }

    public void setPowerStored(int powerStored)
    {
        this.storage.setEnergyStored(powerStored);
    }

    public int getMaxPowerStored()
    {
        return this.storage.getMaxEnergyStored();
    }

    public void setMaxPowerStored(int maxPowerStored)
    {
        this.storage.setCapacity(maxPowerStored);
    }

    @Override
    public int getSizeInventory()
    {
        return 64;
    }

    @Override
    public ItemStack getStackInSlot(int slot)
    {
        return inv[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        if (this.inv[slot] != null)
        {
            ItemStack itemstack;

            if (this.inv[slot].stackSize <= amount)
            {
                itemstack = this.inv[slot];
                this.inv[slot] = null;
                this.markDirty();
                return itemstack;
            }
            else
            {
                itemstack = this.inv[slot].splitStack(amount);

                if (this.inv[slot].stackSize == 0)
                {
                    this.inv[slot] = null;
                }

                this.markDirty();
                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
        if (this.inv[slot] != null)
        {
            ItemStack itemstack = this.inv[slot];
            this.inv[slot] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack itemStack)
    {
        this.inv[slot] = itemStack;

        if (itemStack != null && itemStack.stackSize > this.getInventoryStackLimit())
        {
            itemStack.stackSize = this.getInventoryStackLimit();
        }

        this.markDirty();
    }

    @Override
    public String getInventoryName()
    {
        return "Flux Crystallization Chamber";
    }

    @Override
    public boolean hasCustomInventoryName()
    {
        return false;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this && player.getDistanceSq(
                (double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public void openInventory()
    {
        markDirty();
    }

    @Override
    public void closeInventory()
    {
        markDirty();
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack itemStack)
    {
        return slot == 0 && itemStack != null &&
                (itemStack.getItem() == ItemRegistry.scrap || itemStack.getItem() == ItemRegistry.scrapBag);
    }

    @Override
    public int[] getAccessibleSlotsFromSide(int side)
    {
        switch (side)
        {
            case 0:
                return new int[]{1};
            case 1:
                return new int[]{1};
            default:
                return new int[]{0};
        }
    }

    @Override
    public boolean canInsertItem(int slot, ItemStack itemStack, int side)
    {
        return slot == 0;
    }

    @Override
    public boolean canExtractItem(int slot, ItemStack itemStack, int side)
    {
        return slot == 1;
    }
}

