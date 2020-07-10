package me.majeek.fnaf.game.door;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

public class Door {
    private Material material;
    private Location location;

    private boolean open;

    public Door(Material material, Location location) {
        this.material = material;
        this.location = location;
    }

    public Material getMaterial(){
        return material;
    }

    public Location getLocation(){
        return location;
    }

    public boolean isClosed(){
        if(location.getBlock().getType() == material)
            return true;
        else
            return false;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){

    }
}
