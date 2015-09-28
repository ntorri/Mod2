package com.torridigital.mayhem.network;

import com.torridigital.mayhem.client.gui.GuiMayhem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int MAYHEM_GUI = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == MAYHEM_GUI)
			return new GuiMayhem();
		return null;
	}
}
