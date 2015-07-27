package com.eagle.resonantreflux.integration;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 27/07/2015, 15:29 GMT.
 */
public class ItemStealer
{
    public static ItemStack resonantEnergyCell = null;
    public static ItemStack octadicCapacitor = null;
    public static ItemStack frank = null;
    public static ItemStack receptionCoil = null;
    public static ItemStack capacitorBank = null;

    public static void load()
    {
        resonantEnergyCell = new ItemStack(GameRegistry.findItem("ThermalExpansion", "Cell"), 1, 4);
        octadicCapacitor = new ItemStack(GameRegistry.findItem("EnderIO", "itemBasicCapacitor"), 1, 2);
        frank = new ItemStack(GameRegistry.findItem("EnderIO", "itemFrankenSkull"), 1, 2);
        receptionCoil = new ItemStack(GameRegistry.findItem("ThermalExpansion", "material"), 1, 1);
        capacitorBank = new ItemStack(GameRegistry.findItem("EnderIO", "blockCapBank"), 1, 3);
    }
}
