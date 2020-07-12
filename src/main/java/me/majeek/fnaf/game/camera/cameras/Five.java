package me.majeek.fnaf.game.camera.cameras;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Five extends Camera {
    public Five(){
        super("CAM 5", new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 116.5, 6.5, 37.5, -21, 25), true);
    }
}
