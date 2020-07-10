package me.majeek.fnaf.game.characters.animatronic.animatronics;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Chica extends Animatronic {
    public Chica() {
        super("Chica");
    }

    @Override
    public void toSpawn() {
        Location spawn = new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getDouble("animatronics.chica.spawn.x"), FnafConfig.get().getDouble("animatronics.chica.spawn.y"), FnafConfig.get().getDouble("animatronics.chica.spawn.z"), FnafConfig.get().getInt("animatronics.chica.spawn.yaw"), FnafConfig.get().getInt("animatronics.chica.spawn.pitch"));
        getPlayer().teleport(spawn);
    }
}
