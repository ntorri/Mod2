package com.torridigital.mayhem.entities;

import net.minecraft.nbt.NBTTagCompound;

public interface IEntity 
{
		// set up AI tasks
		void setupAI();
		
		// use clear tasks for subclasses then build up their ai task list specifically
		void clearAITasks();
		
		// initialize the tag compound used for syncing custom entity data
		void initSyncDataCompound();
		
		NBTTagCompound getSyncDataCompound();
		
		void setSyncDataCompound(NBTTagCompound parCompound);
		
		// method to send sync of extended properties from server to clients
		void sendEntitySyncPacket();

		// common encapsulation methods
		void setScaleFactor(float parScaleFactor);
		
		float getScaleFactor();
}
