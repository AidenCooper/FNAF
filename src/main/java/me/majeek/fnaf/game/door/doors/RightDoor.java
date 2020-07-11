package me.majeek.fnaf.game.door.doors;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.door.Door;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class RightDoor extends Door {
    public RightDoor() {
        super("Right Door", Material.valueOf(FnafConfig.get().getString("office.doors.right.material")), new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getInt("office.doors.right.x"), FnafConfig.get().getInt("office.doors.right.y"), FnafConfig.get().getInt("office.doors.right.z")));
    }
}
