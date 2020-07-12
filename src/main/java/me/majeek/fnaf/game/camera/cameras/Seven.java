package me.majeek.fnaf.game.camera.cameras;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Seven extends Camera {
    public Seven() {
        super("CAM 7", new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 84.5, 6.5, 44.5, 148, 32), true);
    }
}
