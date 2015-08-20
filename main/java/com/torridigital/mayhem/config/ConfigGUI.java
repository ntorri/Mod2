package com.torridigital.mayhem.config;

import com.torridigital.mayhem.Main;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigGUI extends GuiConfig {

    public ConfigGUI(GuiScreen parentScreen) {
        super(parentScreen,
                new ConfigElement(Main.instance.config.getCategory(Main.instance.config.CATEGORY_GAMERULES)).getChildElements(),
                Main.MODID, true, false, GuiConfig.getAbridgedConfigPath(Main.instance.config.toString()));
    }
}
