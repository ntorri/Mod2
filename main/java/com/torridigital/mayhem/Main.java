package com.torridigital.mayhem;

import com.torridigital.mayhem.config.Config;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, guiFactory = "com.torridigital.creeperdude.config.GGRGuiFactory", acceptableRemoteVersions = "*")

public class Main {
	public static final String MODID = "mayhem";
    public static final String MODNAME = "Mayhem Mod";
    public static final String VERSION = "1.0.0";

    @Instance
    public static Main instance = new Main();
    public Config config;
    
    @SidedProxy(clientSide="com.torridigital.mayhem.ClientProxy", serverSide="com.torridigital.mayhem.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	proxy.preInit(e);
    	config = new Config(e.getSuggestedConfigurationFile()).loadConfig();
        FMLCommonHandler.instance().bus().register(config);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	proxy.postInit(e);
    }
}
