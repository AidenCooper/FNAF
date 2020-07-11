package me.majeek.fnaf.game.door.doors;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.door.Door;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class LeftDoor extends Door {
    public LeftDoor() {
        super("Left Door", Material.valueOf(FnafConfig.get().getString("office.doors.left.material")), new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getInt("office.doors.left.x"), FnafConfig.get().getInt("office.doors.left.y"), FnafConfig.get().getInt("office.doors.left.z")));
    }
}
