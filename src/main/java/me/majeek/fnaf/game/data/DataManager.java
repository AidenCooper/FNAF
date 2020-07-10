package me.majeek.fnaf.game.data;

import me.majeek.fnaf.game.characters.Guard;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataManager {
    private World world;
    private Guard guard;
    private List<Animatronic> animatronics = new ArrayList<>();

    public World getWorld(){
        return world;
    }

    public void setWorld(World world1){
        world = world1;
    }

    public Guard getGuard(){
        return guard;
    }

    public void setGuard(Guard guard1){
        guard = guard1;
    }

    public List<Animatronic> getAnimatronics() {
        return animatronics;
    }

    public void setAnimatronics(List<Animatronic> animatronics) {
        this.animatronics = animatronics;
    }
}
