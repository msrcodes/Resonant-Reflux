package com.eagle.resonantreflux.networking;

import com.eagle.resonantreflux.tileentities.function.TileEntityFluxCrystallizationChamber;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

/**
 * This class was created by GustoniaEagle.
 * It is distributed under a part of the Resonant Reflux mod.
 * https://github.com/GustoniaEagle/
 * <p/>
 * Resonant Reflux is open source, and available under the
 * GNU General Public License Version 2.
 * <p/>
 * File created @ 26/07/2015, 13:10 GMT.
 */
public class MessageProgress implements IMessage, IMessageHandler<MessageProgress, IMessage>
{
    public int x, y, z, progress, multiplier, multiplierDuration;

    public MessageProgress()
    {

    }

    public MessageProgress(int x, int y, int z, int progress, int multiplier, int multiplierDuration)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.progress = progress;
        this.multiplier = multiplier;
        this.multiplierDuration = multiplierDuration;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        x = buf.readInt();
        y = buf.readInt();
        z = buf.readInt();
        progress = buf.readInt();
        multiplier = buf.readInt();
        multiplierDuration = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(progress);
        buf.writeInt(multiplier);
        buf.writeInt(multiplierDuration);
    }

    @Override
    public IMessage onMessage(MessageProgress message, MessageContext ctx)
    {
        TileEntity tileEntity =
                FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntityFluxCrystallizationChamber)
        {
            ((TileEntityFluxCrystallizationChamber) tileEntity).setProgress(message.progress);
            ((TileEntityFluxCrystallizationChamber) tileEntity).setMultiplier(message.multiplier);
            ((TileEntityFluxCrystallizationChamber) tileEntity).setMultiplierDuration(message.multiplierDuration);
        }

        return null;
    }
}
