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

import java.util.ArrayList;
import java.util.List;

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
    private float mouseX, mouseY;

    public GuiFluxCrystallizationChamber(InventoryPlayer inventoryPlayer, TileEntityFluxCrystallizationChamber tileEntity)
    {
        super(new ContainerFluxCrystallizationChamber(inventoryPlayer, tileEntity));
        this.tileEntity = tileEntity;
    }

    public void drawScreen(int par1, int par2, float par3)
    {
        this.mouseX = (float) par1;
        this.mouseY = (float) par2;
        super.drawScreen(par1, par2, par3);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y)
    {
        fontRendererObj.drawString("Crystallization Chamber", 8, 6, 4210752);
        fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, ySize - 96 + 2, 4210752);
        fontRendererObj.drawString("§eProgress: " + Integer.toString(getProgressAsPercentage()) + "%", 30, 25, 4210752);
        fontRendererObj.drawString("§eMultiplier: " + tileEntity.getMultiplier() + "x", 30, 39, 4210752);
        drawGuiPowerBar();
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

    private void drawGuiPowerBar()
    {
        int x2 = (width - xSize) / 2;
        int y2 = (height - ySize) / 2;

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(Dictionary.GUI_CRYSTALCHAMBER);
        int powerStored = tileEntity.getPowerStored();
        int maxPowerStored = tileEntity.getMaxPowerStored();
        float powerPercentage = (float) powerStored / maxPowerStored;
        float barHeight = powerPercentage * 40;
        drawTexturedModalRect(10, 63 - Math.round(barHeight), 176, 16, 12, Math.round(barHeight));

        if (mouseX > 8 + x2 && mouseX < 23 + x2)
        {
            if (mouseY > 21 + y2 && mouseY < 64 + y2)
            {
                List list = new ArrayList();
                list.add(tileEntity.getPowerStored() + " / " + tileEntity.getMaxPowerStored() + " RF");
                this.drawHoveringText(list, (int) mouseX - x2, (int) mouseY - y2, fontRendererObj);
            }
        }
    }

}
