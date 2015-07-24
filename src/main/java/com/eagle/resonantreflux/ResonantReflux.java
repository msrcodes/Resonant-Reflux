package com.eagle.resonantreflux;

import com.eagle.resonantreflux.registry.BlockRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Dictionary.MOD_ID, version = Dictionary.VERSION)
public class ResonantReflux
{
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        BlockRegistry.load();
    }
}
