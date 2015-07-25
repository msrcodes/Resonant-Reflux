package com.eagle.resonantreflux;

import com.eagle.resonantreflux.gui.GuiHandler;
import com.eagle.resonantreflux.registry.BlockRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = Dictionary.MOD_ID, version = Dictionary.VERSION)
public class ResonantReflux
{
    @Mod.Instance(Dictionary.MOD_ID)
    public static ResonantReflux instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        BlockRegistry.load();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }
}
