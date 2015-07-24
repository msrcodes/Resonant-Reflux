package com.eagle.resonantreflux.registry;

import com.eagle.resonantreflux.Dictionary;
import com.eagle.resonantreflux.blocks.function.BlockFluxCrystallizer;
import com.eagle.resonantreflux.tileentities.function.TileEntityFluxCrystallizer;
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
    public static Block blockFluxCrystallizer = new BlockFluxCrystallizer();

    public static void load()
    {
        GameRegistry.registerBlock(blockFluxCrystallizer, Dictionary.UNLOCALIZED_FLUXCRYSTALLIZER);
        GameRegistry.registerTileEntity(TileEntityFluxCrystallizer.class, Dictionary.UNLOCALIZED_FLUXCRYSTALLIZER);
    }
}
