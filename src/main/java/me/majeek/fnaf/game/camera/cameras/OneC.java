package me.majeek.fnaf.game.camera.cameras;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class OneC extends Camera {
    public OneC(){
        super("CAM 1C", new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 108.5, 6.5, 28.5, -74, 18), true);
    }
}
