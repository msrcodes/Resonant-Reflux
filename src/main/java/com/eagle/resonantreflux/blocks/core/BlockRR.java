package com.eagle.resonantreflux.blocks.core;

import com.eagle.resonantreflux.Dictionary;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 24/07/2015, 16:52 GMT.
 */
public abstract class BlockRR extends BlockContainer
{
    protected BlockRR()
    {
        super(Material.iron);
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(Dictionary.MOD_ID + ":" + this.getUnlocalizedName());
    }
}
