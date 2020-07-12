package me.majeek.fnaf.game.light;

import org.bukkit.Location;
import org.bukkit.Material;

public class Light {
    private String name;
    private Material material;
    private Location location;

    public Light(String name, Material material, Location location) {
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

    public void light(){
        location.getBlock().setType(material);
    }

    public void unLight(){
        location.getBlock().setType(Material.AIR);
    }

    public boolean isLit(){
        return location.getBlock().getType() == material;
    }
}
