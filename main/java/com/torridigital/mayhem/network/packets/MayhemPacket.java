package com.torridigital.mayhem.network.packets;


import io.netty.buffer.ByteBuf;
import minersbasic.api.network.MessageHandler;
import minersbasic.api.utils.ServerUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MayhemPacket implements IMessage {

	private String message;

	public MayhemPacket() {}

	public MayhemPacket(String message) {
		this.message = message;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.message = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, this.message);
	}

	// =========================================================================

	public static class Handler extends MessageHandler.Server<MayhemPacket> {

		@Override
		public IMessage handleServerMessage(EntityPlayer player, final MayhemPacket msg, MessageContext ctx) {
			ServerUtils.addScheduledTask(new Runnable() {
				@Override public void run() {
					ServerUtils.mc().getConfigurationManager().sendChatMsg(new ChatComponentText(msg.message));
				}
			});
			return null;
		}
	}
}
