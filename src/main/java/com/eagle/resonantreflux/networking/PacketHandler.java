package com.eagle.resonantreflux.networking;

import com.eagle.resonantreflux.Dictionary;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 26/07/2015, 13:08 GMT.
 */
public class PacketHandler
{
    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Dictionary.MOD_ID);

    public static void init()
    {
        INSTANCE.registerMessage(MessageChamber.class, MessageChamber.class, 0, Side.CLIENT);
    }
}
