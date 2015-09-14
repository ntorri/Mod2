package com.torridigital.mayhem;

import com.torridigital.mayhem.config.Config;

import minersbasic.api.network.PacketHandler;
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
 * https://github.com/coolAlias/Tutorial-Demo
 * http://bedrockminer.jimdo.com/modding-tutorials/basic-modding-1-8/
 * http://jabelarminecraft.blogspot.com/
 * https://github.com/MrCrayfish
 * https://github.com/GoryMoon/GlobalGameRules
 * https://github.com/devoxx4kids/materials/blob/master/workshops/minecraft/
 * https://github.com/Choonster/TestMod2/tree/c629341ce0f19a277fc7a5d86e7866488f1197dd/src/main/java/com/choonster/testmod2
 * http://www.minecraftforum.net/forums/mapping-and-modding/mapping-and-modding-tutorials/2282788-1-7-1-8-thexfactor117s-forge-modding-tutorials-20
 * http://minecraft.gamepedia.com/Enchanting
 * http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-tools
 * http://www.getpaint.net/index.html
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
    
    public static PacketHandler packetHandler;
    
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
