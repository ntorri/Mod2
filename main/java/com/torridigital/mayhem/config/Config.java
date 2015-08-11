package com.torridigital.mayhem.config;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.torridigital.mayhem.Main;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Config extends Configuration {

    public static final String CATEGORY_GAMERULES = "gamerules";
    public HashMap<String, Boolean> rules = new HashMap<String, Boolean>();
    public HashMap<String, Boolean> defaults;
    public HashMap<String, String> comments = new HashMap<String, String>();

    public Config(File name) {
        super(name);
        rules.put("commandBlockOutput", true);
        rules.put("doDaylightCycle", true);
        rules.put("doFireTick", true);
        rules.put("doMobLoot", true);
        rules.put("doMobSpawning", true);
        rules.put("keepInventory", false);
        rules.put("mobGriefing", true);
        rules.put("naturalRegeneration", true);

        comments.put("commandBlockOutput", "Command blocks should notify admins when they perform commands");
        comments.put("doDaylightCycle", "Time progression");
        comments.put("doFireTick", "Fire should spread and naturally extinguish");
        comments.put("doMobLoot", "Mobs should drop items");
        comments.put("doMobSpawning", "Mobs should naturally spawn");
        comments.put("keepInventory", "Keep items in inventory after death");
        comments.put("mobGriefing", "Mobs able to change blocks and pick up items");
        comments.put("naturalRegeneration", "Regenerate health naturally if hunger is full enough (doesn't affect external healing, such as golden apples, the Regeneration effect, etc.)");

        addCustomCategoryComment(CATEGORY_GAMERULES, "Set the values 'true' or 'false' if you want to have the GameRule enabled or disabled");
        defaults = (HashMap<String, Boolean>) rules.clone();
    }

    public Config loadConfig() {
        load();
        syncConfigs();
        return this;
    }

    public void saveConfig() {
        ConfigCategory cat = getCategory(CATEGORY_GAMERULES);
        for (Map.Entry<String, Boolean> entry : rules.entrySet()) {
            String rule = entry.getKey();
            Boolean state = entry.getValue();

            Property prop = cat.get(rule);
            prop.setValue(state);
            cat.put(rule, prop);
        }

        if (hasChanged())
            save();
    }

    public void syncConfigs() {
        for (Map.Entry<String, Boolean> entry : rules.entrySet()) {
            String rule = entry.getKey();
            Boolean state = get(CATEGORY_GAMERULES, rule, defaults.get(rule), comments.get(rule)).getBoolean();
            rules.put(rule, state);
        }

        if (hasChanged())
            save();
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equals(Main.MODID))
            syncConfigs();
    }

}
