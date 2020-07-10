package me.majeek.fnaf.game.characters.animatronic.animatronics;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Foxy extends Animatronic {
    public Foxy() {
        super("foxy");
    }

    @Override
    public void toSpawn() {
        Location spawn = new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getDouble("animatronics.foxy.spawn.x"), FnafConfig.get().getDouble("animatronics.foxy.spawn.y"), FnafConfig.get().getDouble("animatronics.foxy.spawn.z"), FnafConfig.get().getInt("animatronics.foxy.spawn.yaw"), FnafConfig.get().getInt("animatronics.foxy.spawn.pitch"));
        getPlayer().teleport(spawn);
    }
}
