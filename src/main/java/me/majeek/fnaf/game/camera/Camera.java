package me.majeek.fnaf.game.camera;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.CameraUseEvent;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Camera {
    private String name;
    private Location location;

    private Player occupant;

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

    public void useCamera(Player player){
        boolean eventCalled = false;

        for(Camera camera : Fnaf.getInstance().getCameraManager().getCameras()){
            if(camera.isOccupied()){
                Fnaf.getInstance().getServer().getPluginManager().callEvent(new CameraUseEvent(player, camera, this));
                eventCalled = true;
            }
        }

        if(!eventCalled){
            Fnaf.getInstance().getServer().getPluginManager().callEvent(new CameraUseEvent(player, null, this));
        }

        player.setSneaking(true);
        player.teleport(location);
    }

    public Player getOccupant() {
        return occupant;
    }

    public void setOccupant(Player occupant) {
        this.occupant = occupant;
    }

    public boolean isOccupied(){
        if(occupant == null){
            return false;
        }

        return true;
    }
}
