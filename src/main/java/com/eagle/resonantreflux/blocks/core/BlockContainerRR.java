package com.eagle.resonantreflux.blocks.core;

import com.eagle.resonantreflux.Dictionary;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

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
public class BlockContainerRR extends BlockContainer
{
    String unlocalizedName;
    TileEntity tileEntity;
    Boolean multitexture = false;

    @SideOnly(Side.CLIENT)
    private IIcon textureTop;

    @SideOnly(Side.CLIENT)
    private IIcon textureSides;

    @SideOnly(Side.CLIENT)
    private IIcon textureBottom;

    public BlockContainerRR(String unlocalizedName, Material material, float hardness, TileEntity tileEntity, boolean multitexture)
    {
        super(material);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setHardness(hardness);
        this.setBlockName(unlocalizedName);
        this.setBlockTextureName(unlocalizedName);
        this.unlocalizedName = unlocalizedName;
        this.tileEntity = tileEntity;
        this.multitexture = multitexture;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister register)
    {
        if (multitexture)
        {
            this.textureTop = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName + "Top");
            this.textureSides = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName + "Side");
            this.textureBottom = register.registerIcon(Dictionary.MOD_ID + ":" + unlocalizedName + "Bottom");
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
                    return this.textureBottom;
                case 1:
                    return this.textureTop;
                default:
                    return this.textureSides;
            }
        }
        else
        {
            return this.blockIcon;
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return tileEntity;
    }
}
