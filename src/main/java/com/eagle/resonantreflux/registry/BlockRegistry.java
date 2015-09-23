package com.eagle.resonantreflux.registry;

import com.eagle.resonantreflux.Dictionary;
import com.eagle.resonantreflux.blocks.function.BlockFluxCrystallizationChamber;
import com.eagle.resonantreflux.blocks.function.BlockRecycler;
import com.eagle.resonantreflux.tileentities.function.TileEntityFluxCrystallizationChamber;
import com.eagle.resonantreflux.tileentities.function.TileEntityRecycler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 24/07/2015, 16:49 GMT.
 */
public class BlockRegistry
{
    public static Block blockFluxCrystallizer = new BlockFluxCrystallizationChamber();
    public static Block blockRecycler = new BlockRecycler();

    public static void load()
    {
        GameRegistry.registerBlock(blockFluxCrystallizer, Dictionary.UNLOCALIZED_CRYSTALCHAMBER);
        GameRegistry.registerBlock(blockRecycler, Dictionary.UNLOCALIZED_RECYCLER);

        GameRegistry.registerTileEntity(TileEntityFluxCrystallizationChamber.class, Dictionary.UNLOCALIZED_CRYSTALCHAMBER);
        GameRegistry.registerTileEntity(TileEntityRecycler.class, Dictionary.UNLOCALIZED_RECYCLER);
    }
}
