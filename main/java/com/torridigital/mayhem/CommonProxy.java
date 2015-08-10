package com.torridigital.mayhem;

import com.torridigital.mayhem.blocks.ModBlocks;
import com.torridigital.mayhem.crafting.ModCrafting;
import com.torridigital.mayhem.items.ModItems;
import com.torridigital.mayhem.network.ModGuiHandler;
import com.torridigital.mayhem.tileentity.ModTileEntities;
import com.torridigital.mayhem.world.MayhemWorldGenerator;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void preInit(FMLPreInitializationEvent e) {
		ModItems.createItems();
		ModBlocks.createBlocks();
		ModTileEntities.init();
    }

    public void init(FMLInitializationEvent e) {
    	ModCrafting.initCrafting();
    	GameRegistry.registerWorldGenerator(new MayhemWorldGenerator(), 0);
    	NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new ModGuiHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {

    }
}
