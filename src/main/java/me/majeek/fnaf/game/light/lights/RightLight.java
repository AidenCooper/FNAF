package me.majeek.fnaf.game.light.lights;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.light.Light;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class RightLight extends Light {
    public RightLight() {
        super("Right Light", Material.valueOf(FnafConfig.get().getString("office.lights.right.material")), new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getInt("office.lights.right.x"), FnafConfig.get().getInt("office.lights.right.y"), FnafConfig.get().getInt("office.lights.right.z")));
    }
}
