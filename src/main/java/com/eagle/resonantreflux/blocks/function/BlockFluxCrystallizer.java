package com.eagle.resonantreflux.blocks.function;

import com.eagle.resonantreflux.Dictionary;
import com.eagle.resonantreflux.blocks.core.BlockContainerRR;
import com.eagle.resonantreflux.tileentities.function.TileEntityFluxCrystallizer;
import net.minecraft.block.material.Material;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 24/07/2015, 17:21 GMT.
 */
public class BlockFluxCrystallizer extends BlockContainerRR
{
    public BlockFluxCrystallizer()
    {
        super(Dictionary.UNLOCALIZED_FLUXCRYSTALLIZER, Material.iron, 3.0F, new TileEntityFluxCrystallizer(), true);
    }
}
