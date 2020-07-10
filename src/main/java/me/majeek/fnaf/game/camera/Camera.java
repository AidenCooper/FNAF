package me.majeek.fnaf.game.camera;

import org.bukkit.Location;

public class Camera {
    private String name;
    private Location location;

    public Camera(String name, Location location){
        this.name = name;
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public Location getLocation(){
        return location;
    }
}
