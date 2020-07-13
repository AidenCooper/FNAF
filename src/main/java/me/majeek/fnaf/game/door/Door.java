package me.majeek.fnaf.game.door;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.DoorUseEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class Door {
    private String name;

    public Door(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Material getMaterial(){
        return Material.AIR;
    }

    public Location getLocation(){
        return new Location(Bukkit.getWorld("world"), 0, 0, 0);
    }

    public void open(){
        Fnaf.getInstance().getServer().getPluginManager().callEvent(new DoorUseEvent(this, true));

        getLocation().getBlock().setType(Material.AIR);
        getAbove().getBlock().setType(Material.AIR);
    }

    public void close(){
        Fnaf.getInstance().getServer().getPluginManager().callEvent(new DoorUseEvent(this, false));

        getLocation().getBlock().setType(getMaterial());
        getAbove().getBlock().setType(getMaterial());
    }

    public boolean isClosed(){
        return getLocation().getBlock().getType() == getMaterial() || getAbove().getBlock().getType() == getMaterial();
    }

    private Location getAbove(){
        Location aboveBlock = getLocation().clone();
        aboveBlock.setY(aboveBlock.getY() + 1);
        return aboveBlock;
    }
}
