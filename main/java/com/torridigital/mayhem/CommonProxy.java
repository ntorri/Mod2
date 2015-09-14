package com.torridigital.mayhem;

import com.torridigital.mayhem.blocks.ModBlocks;
import com.torridigital.mayhem.config.Config;
import com.torridigital.mayhem.crafting.ModCrafting;
import com.torridigital.mayhem.items.ModItems;
import com.torridigital.mayhem.network.ModGuiHandler;
import com.torridigital.mayhem.network.packets.MayhemPacket;
import com.torridigital.mayhem.tileentity.ModTileEntities;
import com.torridigital.mayhem.world.MayhemWorldGenerator;
import com.torridigital.mayhem.world.WorldEvents;

import minersbasic.api.MinersbasicAPI;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy {
	
	public void generateMysteriousParticles(Entity theEntity) { }
	
	public void preInit(FMLPreInitializationEvent e) {
		ModItems.createItems();
		ModBlocks.createBlocks();
		ModTileEntities.init();
		Main.config = new Config(e.getSuggestedConfigurationFile()).loadConfig();
        FMLCommonHandler.instance().bus().register(Main.config);
    }

    public void init(FMLInitializationEvent e) {
    	ModCrafting.initCrafting();
    	Enchantment.addToBookList(Main.haste);
    	MinecraftForge.EVENT_BUS.register(Main.haste);
    	MinecraftForge.EVENT_BUS.register(new WorldEvents());
    	GameRegistry.registerWorldGenerator(new MayhemWorldGenerator(), 0);
    	NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new ModGuiHandler());
    	Main.packetHandler = MinersbasicAPI.createPacketHandler("mayhem");
		Main.packetHandler.registerPacket(MayhemPacket.class, new MayhemPacket.Handler(), Side.SERVER);
    }

    public void postInit(FMLPostInitializationEvent e) {
    }
}
