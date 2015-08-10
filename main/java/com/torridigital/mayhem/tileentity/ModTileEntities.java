package com.torridigital.mayhem.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModTileEntities {

	public static void init() {
		GameRegistry.registerTileEntity(ModTileEntity.class, "mayhem_tile_entity");
	}
}
