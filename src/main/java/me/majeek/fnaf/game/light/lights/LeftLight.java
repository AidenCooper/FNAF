package me.majeek.fnaf.game.light.lights;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.light.Light;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class LeftLight extends Light {
    public LeftLight() {
        super("Left Light", Material.valueOf(FnafConfig.get().getString("office.lights.left.material")), new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getInt("office.lights.left.x"), FnafConfig.get().getInt("office.lights.left.y"), FnafConfig.get().getInt("office.lights.left.z")));
    }
}
