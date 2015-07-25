package com.eagle.resonantreflux.gui;

import com.eagle.resonantreflux.container.ContainerFluxCrystallizationChamber;
import com.eagle.resonantreflux.tileentities.function.TileEntityFluxCrystallizationChamber;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 25/07/2015, 15:23 GMT.
 */
public class GuiHandler implements IGuiHandler
{
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileEntityFluxCrystallizationChamber)
        {
            return new ContainerFluxCrystallizationChamber(player.inventory, (TileEntityFluxCrystallizationChamber) tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof TileEntityFluxCrystallizationChamber)
        {
            return new GuiFluxCrystallizationChamber(player.inventory, (TileEntityFluxCrystallizationChamber) tileEntity);
        }
        return null;
    }
}
