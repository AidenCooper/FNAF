package me.majeek.fnaf.game.light;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.LightUseEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class Light {
    private String name;

    public Light(String name) {
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

    public void light(){
        for(Light light : Fnaf.getInstance().getLightManager().getLights())
            if(light != this && light.isLit())
                light.unLight();

        Fnaf.getInstance().getServer().getPluginManager().callEvent(new LightUseEvent(this, true));

        getLocation().getBlock().setType(getMaterial());
    }

    public void unLight(){
        Fnaf.getInstance().getServer().getPluginManager().callEvent(new LightUseEvent(this, false));

        getLocation().getBlock().setType(Material.AIR);
    }

    public boolean isLit(){
        return getLocation().getBlock().getType() == getMaterial();
    }
}
