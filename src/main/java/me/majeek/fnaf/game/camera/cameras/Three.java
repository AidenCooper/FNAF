package me.majeek.fnaf.game.camera.cameras;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Three extends Camera {
    public Three() {
        super("CAM 3", new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 108.5, 6.5, 22.5, -165, 46), true);
    }
}
