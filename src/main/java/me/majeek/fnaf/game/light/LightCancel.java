package me.majeek.fnaf.game.light;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.CameraUseEvent;
import me.majeek.fnaf.events.DoorUseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class LightCancel implements Listener {
    @EventHandler
    public void onCameraUse(CameraUseEvent event){
        if(event.getFrom().getName().equalsIgnoreCase("OFFICE") && !event.getTo().getName().equalsIgnoreCase("OFFICE"))
            for(Light light : Fnaf.getInstance().getLightManager().getLights())
                if(light.isLit())
                    light.unLight();
    }

    @EventHandler
    public void onDoorUse(DoorUseEvent event){
        for(Light light : Fnaf.getInstance().getLightManager().getLights())
            if(light.isLit())
                light.unLight();
    }
}
