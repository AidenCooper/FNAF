package me.majeek.fnaf.game.door;

import me.majeek.fnaf.files.FnafConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class SecurityOne extends Door {
    public SecurityOne() {
        super(Material.valueOf(FnafConfig.get().getString("office.doors.door1.material")), new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getInt("office.doors.door1.x"), FnafConfig.get().getInt("office.doors.door1.y"), FnafConfig.get().getInt("office.doors.door1.z")));
    }
}
