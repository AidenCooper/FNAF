package me.majeek.fnaf.game.camera.cameras;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Office extends Camera {
    public Office() {
        super("OFFICE", new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 100.5, 4, 15.5, 0, 0));
    }
}
