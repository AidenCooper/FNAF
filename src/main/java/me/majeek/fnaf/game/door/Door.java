package me.majeek.fnaf.game.door;

import org.bukkit.Location;
import org.bukkit.Material;

public class Door {
    private String name;
    private Material material;
    private Location location;

    public Door(String name, Material material, Location location) {
        this.name = name;
        this.material = material;
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public Material getMaterial(){
        return material;
    }

    public Location getLocation(){
        return location;
    }

    public void open(){
        location.getBlock().setType(Material.AIR);
        getAbove().getBlock().setType(Material.AIR);
    }

    public void close(){
        location.getBlock().setType(material);
        getAbove().getBlock().setType(material);
    }

    public boolean isClosed(){
        return location.getBlock().getType() == material || getAbove().getBlock().getType() == material;
    }

    private Location getAbove(){
        Location aboveBlock = location.clone();
        aboveBlock.setY(aboveBlock.getY() + 1);
        return aboveBlock;
    }
}
