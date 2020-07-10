package me.majeek.fnaf.game.characters.animatronic.animatronics;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Bonnie extends Animatronic {
    public Bonnie() {
        super("Bonnie");
    }

    @Override
    public void toSpawn() {
        Location spawn = new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getDouble("animatronics.bonnie.spawn.x"), FnafConfig.get().getDouble("animatronics.bonnie.spawn.y"), FnafConfig.get().getDouble("animatronics.bonnie.spawn.z"), FnafConfig.get().getInt("animatronics.bonnie.spawn.yaw"), FnafConfig.get().getInt("animatronics.bonnie.spawn.pitch"));
        getPlayer().teleport(spawn);
    }
}
