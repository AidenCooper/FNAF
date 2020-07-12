package me.majeek.fnaf.game.camera.cameras;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class FourB extends Camera {
    public FourB() {
        super("CAM 4B", new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 96.5, 6.5, 16.5, 153, 35), true);
    }
}
