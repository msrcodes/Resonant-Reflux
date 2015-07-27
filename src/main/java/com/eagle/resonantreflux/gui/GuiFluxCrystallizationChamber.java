package com.eagle.resonantreflux.gui;

import com.eagle.resonantreflux.Dictionary;
import com.eagle.resonantreflux.container.ContainerFluxCrystallizationChamber;
import com.eagle.resonantreflux.tileentities.function.TileEntityFluxCrystallizationChamber;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 25/07/2015, 14:54 GMT.
 */
@SideOnly(Side.CLIENT)
public class GuiFluxCrystallizationChamber extends GuiContainer
{
    private TileEntityFluxCrystallizationChamber tileEntity;

    public GuiFluxCrystallizationChamber(InventoryPlayer inventoryPlayer, TileEntityFluxCrystallizationChamber tileEntity)
    {
        super(new ContainerFluxCrystallizationChamber(inventoryPlayer, tileEntity));
        this.tileEntity = tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        fontRendererObj.drawString("Crystallization Chamber", 8, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
        fontRendererObj.drawString("§eProgress: " + Integer.toString(getProgressAsPercentage()) + "%", 30, 25, 4210752);
        fontRendererObj.drawString("§eMultiplier: " + tileEntity.getMultiplier() + "x", 30, 39, 4210752);
        if (tileEntity.getMultiplierDuration() != 0)
        {
            fontRendererObj.drawString("§eDuration: " + tileEntity.getMultiplierDuration() + " ticks", 30, 53, 4210752);
        }
    }

    private int getProgressAsPercentage()
    {
        return (int) ((tileEntity.getProgress() * 100.0F) / 40000000);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int x, int y)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(Dictionary.GUI_CRYSTALCHAMBER);
        int x2 = (width - xSize) / 2;
        int y2 = (height - ySize) / 2;
        this.drawTexturedModalRect(x2, y2, 0, 0, xSize, ySize);
    }
}
