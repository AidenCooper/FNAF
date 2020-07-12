package me.majeek.fnaf.game.camera.cameras;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class TwoB extends Camera {
    public TwoB() {
        super("CAM 2B", new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 104.5, 6.5, 16.5, -153, 35), true);
    }
}
