package com.torridigital.mayhem.event;

import com.torridigital.mayhem.entitydata.PlayerData;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerCommon {
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing e) {
		if (e.entity instanceof EntityPlayer) {
			PlayerData.register((EntityPlayer) e.entity);
		}
	}

	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent e) {
		if (e.entity instanceof EntityPlayer) {
			PlayerData.get((EntityPlayer) e.entity).requestSyncAll();
		}
	}

	@SubscribeEvent
	public void onPlayerCloned(PlayerEvent.Clone e) {
		NBTTagCompound nbt = new NBTTagCompound();
		PlayerData.get(e.original).saveReviveRelevantNBTData(nbt, e.wasDeath);
		PlayerData.get(e.entityPlayer).loadNBTData(nbt);
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onPlayerPickupXP(PlayerPickupXpEvent e) {
		e.orb.xpValue *= 2;
	}

	@SubscribeEvent
	public void onEntityGetHurt(LivingHurtEvent e) {
		if (e.entity instanceof EntityPlayer)
			e.setCanceled(true);
	}
}
