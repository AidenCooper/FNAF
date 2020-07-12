package me.majeek.fnaf.game.camera;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.PlayerLookEvent;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class CameraMovement implements Listener {
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        if(Fnaf.getInstance().getDataManager().getGuard() != null && Fnaf.getInstance().getDataManager().getGuard().getPlayer().getName().equalsIgnoreCase(event.getPlayer().getName())){
            for(Camera camera : Fnaf.getInstance().getCameraManager().getCameras()){
                if(camera.isOccupied() && camera.getOccupant().getName().equalsIgnoreCase(event.getPlayer().getName())){
                    Location cameraLocation = camera.getLocation().clone();
                    Location playerLocation = event.getPlayer().getLocation().clone();

                    if(camera.getName().equalsIgnoreCase("OFFICE")){
                        if(playerLocation.getX() != cameraLocation.getX() || playerLocation.getY() != cameraLocation.getY() || playerLocation.getZ() != cameraLocation.getZ()){
                            cameraLocation.setPitch(playerLocation.getPitch());
                            cameraLocation.setYaw(playerLocation.getYaw());

                            event.getPlayer().teleport(cameraLocation);
                            return;
                        }
                    } else{
                        if(playerLocation.getX() != cameraLocation.getX() || playerLocation.getY() != cameraLocation.getY() || playerLocation.getZ() != cameraLocation.getZ()){
                            event.getPlayer().teleport(cameraLocation);
                            return;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerLook(PlayerLookEvent event){
        if(Fnaf.getInstance().getDataManager().getGuard() != null && Fnaf.getInstance().getDataManager().getGuard().getPlayer().getName().equalsIgnoreCase(event.getPlayer().getName())){
            for(Camera camera : Fnaf.getInstance().getCameraManager().getCameras()){
                if(camera.isOccupied() && camera.getOccupant().getName().equalsIgnoreCase(event.getPlayer().getName())){
                    Location cameraLocation = camera.getLocation().clone();
                    Location playerLocation = event.getPlayer().getLocation().clone();

                    if(!camera.getName().equalsIgnoreCase("OFFICE")){
                        if(playerLocation.getPitch() != cameraLocation.getPitch() || playerLocation.getYaw() != cameraLocation.getYaw()){
                            event.getPlayer().teleport(cameraLocation);
                            return;
                        }
                    }
                }
            }
        }
    }
}
