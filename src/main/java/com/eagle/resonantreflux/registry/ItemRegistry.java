package com.eagle.resonantreflux.registry;

import com.eagle.resonantreflux.Dictionary;
import com.eagle.resonantreflux.items.ItemRR;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

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
public class ItemRegistry
{
    public static ItemRR fluxCrystal, scrap, scrapBag;

    public static void load()
    {
        fluxCrystal = new ItemRR(Dictionary.UNLOCALIZED_FLUXCRYSTAL);
        scrap = new ItemRR(Dictionary.UNLOCALIZED_SCRAP);
        scrapBag = new ItemRR(Dictionary.UNLOCALIZED_SCRAPBAG);

        GameRegistry.registerItem(fluxCrystal, Dictionary.UNLOCALIZED_FLUXCRYSTAL);
        GameRegistry.registerItem(scrap, Dictionary.UNLOCALIZED_SCRAP);
        GameRegistry.registerItem(scrapBag, Dictionary.UNLOCALIZED_SCRAPBAG);

        OreDictionary.registerOre("itemScrap", scrap);
        OreDictionary.registerOre("itemScrapBag", scrapBag);
    }
}
