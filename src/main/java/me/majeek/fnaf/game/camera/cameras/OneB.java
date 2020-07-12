package me.majeek.fnaf.game.camera.cameras;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class OneB extends Camera {
    public OneB(){
        super("CAM 1B", new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 107.5, 6.5, 44.5, 145, 22), true);
    }
}
