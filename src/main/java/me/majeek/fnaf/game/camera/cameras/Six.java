package me.majeek.fnaf.game.camera.cameras;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Six extends Camera {
    public Six() {
        super("CAM 6", new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 92.5, 6.5, 24.5, 73, 22), false);
    }
}
