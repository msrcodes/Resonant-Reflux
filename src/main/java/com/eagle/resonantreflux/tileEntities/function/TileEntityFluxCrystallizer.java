package com.eagle.resonantreflux.tileentities.function;

import com.eagle.resonantreflux.tileentities.core.TileEntityRR;
import net.minecraft.nbt.NBTTagCompound;

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
public class TileEntityFluxCrystallizer extends TileEntityRR
{
    public TileEntityFluxCrystallizer()
    {
        //40000000 RF per Crystal (40 million), but can be lowered to 6666668 RF per with boost.
        super(40000000, 2048);
    }

    @Override
    public void updateEntity()
    {

    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound)
    {
        super.readFromNBT(tagCompound);
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound)
    {
        super.writeToNBT(tagCompound);
    }
}
