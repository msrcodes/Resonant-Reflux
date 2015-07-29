package com.eagle.resonantreflux;

import net.minecraft.util.ResourceLocation;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 24/07/2015, 16:44 GMT.
 */
public class Dictionary
{
    public static final String MOD_ID = "ResonantReflux";
    public static final String VERSION = "1.0.0";

    public static final String UNLOCALIZED_CRYSTALCHAMBER = "fluxCrystalChamber";
    public static final String UNLOCALIZED_FLUXCRYSTAL = "fluxCrystal";
    public static final String UNLOCALIZED_SCRAP = "scrap";
    public static final String UNLOCALIZED_SCRAPBAG = "scrapBag";
    public static final ResourceLocation GUI_CRYSTALCHAMBER =
            new ResourceLocation(MOD_ID.toLowerCase(), "textures/gui/fluxCrystalChamber.png");

    public enum Gui
    {
        CRYSTAL_CHAMBER
    }
}
