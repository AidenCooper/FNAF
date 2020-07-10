package me.majeek.fnaf.game.door;

import me.majeek.fnaf.files.FnafConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class SecurityTwo extends Door {
    public SecurityTwo() {
        super(Material.valueOf(FnafConfig.get().getString("office.doors.door2.material")), new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getInt("office.doors.door2.x"), FnafConfig.get().getInt("office.doors.door2.y"), FnafConfig.get().getInt("office.doors.door2.z")));
    }
}
