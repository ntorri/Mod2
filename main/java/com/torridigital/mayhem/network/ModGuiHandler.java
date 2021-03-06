package com.torridigital.mayhem.network;

import com.torridigital.mayhem.client.gui.GuiModTileEntity;
import com.torridigital.mayhem.guicontainer.ContainerModTileEntity;
import com.torridigital.mayhem.tileentity.ModTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {

	public static final int MOD_TILE_ENTITY_GUI = 0;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == MOD_TILE_ENTITY_GUI)
			return new ContainerModTileEntity(player.inventory, (ModTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
			return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == MOD_TILE_ENTITY_GUI)
			return new GuiModTileEntity(player.inventory, (ModTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
			return null;
	}
}
