package com.github.wyrdix.netherchangeratio;

import com.github.wyrdix.netherchangeratio.nms.Fixer_1_18_1;
import org.bukkit.plugin.java.JavaPlugin;

public final class NetherChangeRatio extends JavaPlugin {
    @Override
    public void onLoad() {
        saveDefaultConfig();
        double ratio = getConfig().getDouble("ratio", 8d);
        try {
            String version = getServer().getMinecraftVersion();
            if(version.equals("1.18.1")) Fixer_1_18_1.change(ratio);
            else getLogger().warning("The minecraft version you are using is currently not supported by this plugin. For reference your minecraft version is : "+version);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
