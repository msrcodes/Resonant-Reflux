package com.eagle.resonantreflux.integration;

import cpw.mods.fml.common.Loader;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 27/07/2015, 16:15 GMT.
 */
public class ModChecker
{
    public static boolean teLoaded, tfLoaded, eioLoaded = false;

    public static void check()
    {
        if (Loader.isModLoaded("ThermalExpansion"))
        {
            teLoaded = true;
        }
        if (Loader.isModLoaded("ThermalFoundation"))
        {
            tfLoaded = true;
        }
        if (Loader.isModLoaded("EnderIO"))
        {
            eioLoaded = true;
        }
    }
}
