package me.majeek.fnaf.game.characters.animatronic.animatronics;

import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Freddy extends Animatronic {
    public Freddy() {
        super("freddy");
    }

    @Override
    public void toSpawn() {
        Location spawn = new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getDouble("animatronics.freddy.spawn.x"), FnafConfig.get().getDouble("animatronics.freddy.spawn.y"), FnafConfig.get().getDouble("animatronics.freddy.spawn.z"), FnafConfig.get().getInt("animatronics.freddy.spawn.yaw"), FnafConfig.get().getInt("animatronics.freddy.spawn.pitch"));
        getPlayer().teleport(spawn);
    }
}
