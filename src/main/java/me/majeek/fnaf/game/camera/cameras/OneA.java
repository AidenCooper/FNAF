package me.majeek.fnaf.game.camera.cameras;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class OneA extends Camera {
    public OneA() {
        super("CAM 1A", new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 106.5, 6.5, 45.5, 60, 20));
    }
}
