package com.torridigital.mayhem.entitydata;

import com.torridigital.mayhem.Main;
import com.torridigital.mayhem.network.packets.PacketSyncMana;
import com.torridigital.mayhem.network.packets.PacketSyncPlayerData;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerData implements IExtendedEntityProperties {

	private static final String identifier = "mayhemPlayerData";

	// PROPERTIES =============================================================

	private final EntityPlayer player;

	private int mana;

	// CONSTRUCTOR, GETTER, REGISTER ==========================================

	public PlayerData(EntityPlayer player) {
		this.player = player;
		this.mana = 100;
	}

	public static PlayerData get(EntityPlayer player) {
		return (PlayerData) player.getExtendedProperties(identifier);
	}

	public static void register(EntityPlayer player) {
		player.registerExtendedProperties(identifier, new PlayerData(player));
	}

	public boolean isServerSide() {
		return this.player instanceof EntityPlayerMP;
	}

	// LOAD, SAVE =============================================================

	@Override
	public void saveNBTData(NBTTagCompound nbt) {
		nbt.setInteger("mana", this.getMana());
	}

	public void saveReviveRelevantNBTData(NBTTagCompound nbt, boolean wasDeath) {
		if (!wasDeath)
			this.saveNBTData(nbt);
	}

	@Override
	public void loadNBTData(NBTTagCompound nbt) {
		if (nbt.hasKey("mana", 3))
			this.setMana(nbt.getInteger("mana"));
	}

	@Override
	public void init(Entity entity, World world) {
	}

	// GETTER, SETTER, SYNCER =================================================

	public void setMana(int mana) {
		this.mana = mana;
		this.syncMana();
	}

	public int getMana() {
		return this.mana;
	}

	public void syncMana() {
		if (this.isServerSide())
			Main.packetHandler.sendTo(new PacketSyncMana(this.getMana()), (EntityPlayerMP) this.player);
	}

	public void syncAll() {
		if (this.isServerSide())
			Main.packetHandler.sendTo(new PacketSyncPlayerData(this), (EntityPlayerMP) this.player);
	}

	public void requestSyncAll() {
		if (!this.isServerSide())
			Main.packetHandler.sendToServer(new PacketSyncPlayerData());
	}
}
