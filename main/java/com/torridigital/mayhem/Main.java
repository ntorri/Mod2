package com.torridigital.mayhem;

import com.torridigital.mayhem.config.Config;
import com.torridigital.mayhem.world.WorldEvents;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent.NameFormat;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * 
 * @author ntorri
 * http://bedrockminer.jimdo.com/modding-tutorials/basic-modding-1-8/basic-modfile/
 */

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION, guiFactory = "com.torridigital.mayhem.config.GuiFactory", acceptableRemoteVersions = "*")

public class Main {
	public static final String MODID = "mayhem";
    public static final String MODNAME = "Mayhem Mod";
    public static final String VERSION = "@MOD_VERSION@";
    
    public static Config config;
    
    public static final CreativeTabs tabMayhem = new MayhemTab(CreativeTabs.getNextID(), "standard");
    public static final Enchantment haste = new EnchantmentArrowFast(150, new ResourceLocation("haste"), 2);

    @Mod.Instance
    public static Main instance = new Main();
    
    @SidedProxy(clientSide="com.torridigital.mayhem.ClientProxy", serverSide="com.torridigital.mayhem.ServerProxy")
    public static CommonProxy proxy;
    
    @SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(NameFormat event)
    {
        if (event.username.equalsIgnoreCase("creeperdude719"))
        {
            event.displayname = event.username+" the Great and Powerful";
        }       
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	proxy.preInit(e);
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
