package com.torridigital.mayhem.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerPickupXpEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerCommon {
	
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
