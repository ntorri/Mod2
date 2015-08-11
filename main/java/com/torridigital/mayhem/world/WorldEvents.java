package com.torridigital.mayhem.world;

import java.util.Map;

import com.torridigital.mayhem.Main;

import net.minecraft.world.GameRules;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * https://github.com/GoryMoon/GlobalGameRules/tree/master/src/main/java/se/gory_moon/globalgamerules
 * 
 *
 */
public class WorldEvents {
	@SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        GameRules gRules = event.world.getGameRules();

        for (Map.Entry<String, Boolean> entry : Main.instance.config.rules.entrySet()) {
            String rule = entry.getKey();
            Boolean state = entry.getValue();
            gRules.setOrCreateGameRule(rule, state ? "true" : "false");
        }

    }

    @SubscribeEvent
    public void onWorldUnLoad(WorldEvent.Unload event) {
        GameRules gRules = event.world.getGameRules();

        for (Map.Entry<String, Boolean> entry : Main.instance.config.rules.entrySet()) {
            String rule = entry.getKey();
            Boolean state = gRules.getGameRuleBooleanValue(rule);
            Main.instance.config.rules.put(rule, state);
        }

        Main.instance.config.saveConfig();

    }
}
