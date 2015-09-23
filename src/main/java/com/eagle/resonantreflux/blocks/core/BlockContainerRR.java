package com.eagle.resonantreflux.blocks.core;

import cofh.api.energy.IEnergyReceiver;
import com.eagle.resonantreflux.Dictionary;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

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
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        world.setBlockMetadataWithNotify(x, y, z, get2dOrientation(entity).getOpposite().ordinal(), 3);
    }

    private static ForgeDirection get2dOrientation(EntityLivingBase entity)
    {
        ForgeDirection[] orientationTable = {ForgeDirection.SOUTH,
                ForgeDirection.WEST, ForgeDirection.NORTH, ForgeDirection.EAST};
        int orientationIndex = MathHelper.floor_double((entity.rotationYaw + 45.0) / 90.0) & 3;
        return orientationTable[orientationIndex];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 0 && side == 3)
            return this.frontOff;

        if (side == meta && meta > 1)
        {
            IEnergyReceiver tileEntity = (IEnergyReceiver) world.getTileEntity(x, y, z);
            if (tileEntity.getEnergyStored(ForgeDirection.UNKNOWN) >= 2000)
            {
                return this.frontOn;
            }
            return this.frontOff;
        }

        if (side == ForgeDirection.getOrientation(meta).getOpposite().ordinal())
            return back;

        switch (side)
        {
            case 0:
                return bottom;
            case 1:
                return top;
            case 2:
                if (ForgeDirection.getOrientation(meta) == ForgeDirection.WEST)
                    return right;
                return left;
            case 3:
                if (ForgeDirection.getOrientation(meta) == ForgeDirection.WEST)
                    return left;
                return right;
            case 4:
                if (ForgeDirection.getOrientation(meta) == ForgeDirection.SOUTH)
                    return right;
                return left;
            case 5:
                if (ForgeDirection.getOrientation(meta) == ForgeDirection.SOUTH)
                    return left;
                return right;
        }
        return null;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        if (meta == 0 && side == 3)
            return this.frontOff;

        if (side == meta && meta > 1)
        {
            return this.frontOff;
        }

        switch (side)
        {
            case 0:
                return bottom;
            case 1:
                return top;
            case 2:
                if (ForgeDirection.getOrientation(meta) == ForgeDirection.WEST)
                    return right;
                return left;
            case 3:
                if (ForgeDirection.getOrientation(meta) == ForgeDirection.WEST)
                    return left;
                return right;
            case 4:
                if (ForgeDirection.getOrientation(meta) == ForgeDirection.SOUTH)
                    return right;
                return left;
            case 5:
                if (ForgeDirection.getOrientation(meta) == ForgeDirection.SOUTH)
                    return left;
                return right;
        }
        return null;
    }

}
