package com.eagle.resonantreflux.items;

import com.eagle.resonantreflux.Dictionary;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 27/07/2015, 11:39 GMT.
 */
public class ItemRR extends Item
{
    String name;

    public ItemRR(String name)
    {
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setUnlocalizedName(name);
        this.name = name;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(Dictionary.MOD_ID + ":" + name);
    }
}
