package com.torridigital.mayhem.network.packets;

import com.torridigital.mayhem.entitydata.PlayerData;
import io.netty.buffer.ByteBuf;
import minersbasic.api.network.MessageHandler;
import minersbasic.api.utils.ClientUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketSyncMana implements IMessage {

	private int mana;

	public PacketSyncMana() {}

	public PacketSyncMana(int mana) {
		this.mana = mana;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.mana = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.mana);
	}

	// ========================================================================
	public static class Handler extends MessageHandler.Client<PacketSyncMana> {
	
		@Override
		public IMessage handleClientMessage(final EntityPlayer player, final PacketSyncMana msg, MessageContext ctx) {
			ClientUtils.addScheduledTask(new Runnable() {
				@Override
				public void run() {
					PlayerData.get(player).setMana(msg.mana);
				}
			});
			return null;
		}
	}
}
