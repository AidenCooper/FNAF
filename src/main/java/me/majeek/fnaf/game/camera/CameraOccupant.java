package me.majeek.fnaf.game.camera;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.CameraUseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CameraOccupant implements Listener {
    @EventHandler
    public void onCameraUse(CameraUseEvent event){
        if(event.getFrom() != null)
            event.getFrom().setOccupant(null);

        for(Camera camera : Fnaf.getInstance().getCameraManager().getCameras())
            if(event.getTo() == camera)
                event.getTo().setOccupant(event.getPlayer());
    }
}
