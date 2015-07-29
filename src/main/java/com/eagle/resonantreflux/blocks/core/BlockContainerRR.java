package com.eagle.resonantreflux.blocks.core;

import com.eagle.resonantreflux.Dictionary;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 24/07/2015, 17:31 GMT.
 */
public abstract class BlockContainerRR extends BlockContainer
{
    String unlocalizedName;
    Boolean multitexture = false;

    @SideOnly(Side.CLIENT)
    private IIcon back, bottom, frontOff, frontOn, left, right, top;

    public BlockContainerRR(String unlocalizedName, Material material, float hardness, boolean multitexture)
    {
        super(material);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setHardness(hardness);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(unlocalizedName);
        this.unlocalizedName = unlocalizedName;
        this.multitexture = multitexture;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        if (multitexture)
        {
            this.back = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName + "/" + "back");
            this.bottom = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName + "/" + "bottom");
            this.frontOff = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName + "/" + "frontOff");
            this.frontOn = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName + "/" + "frontOn");
            this.left = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName + "/" + "left");
            this.right = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName + "/" + "right");
            this.top = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName + "/" + "top");
        }
        else
        {
            this.blockIcon = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName);
        }
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if (multitexture)
        {
            switch (side)
            {
                case 0:
                    return this.bottom;
                case 1:
                    return this.top;
                case 2:
                    return this.back;
                case 3:
                    return this.frontOn;
                case 4:
                    return this.right;
                case 5:
                    return this.left;
                default:
                    return this.bottom;
            }
        }
        else
        {
            return this.blockIcon;
        }
    }

}
