package me.majeek.fnaf.game.power;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.CameraUseEvent;
import me.majeek.fnaf.events.DoorUseEvent;
import me.majeek.fnaf.events.LightUseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PowerChangeUsage implements Listener {
    @EventHandler
    public void onCameraUse(CameraUseEvent event){
        if(Fnaf.getInstance().getGame().inProgress()){
            if(event.getFrom().getName().equalsIgnoreCase("OFFICE") && !event.getTo().getName().equalsIgnoreCase("OFFICE")){
                Fnaf.getInstance().getPowerManager().setUsage(Fnaf.getInstance().getPowerManager().getUsage() + 1);
            } else if(!event.getFrom().getName().equalsIgnoreCase("OFFICE") && event.getTo().getName().equalsIgnoreCase("OFFICE")){
                Fnaf.getInstance().getPowerManager().setUsage(Fnaf.getInstance().getPowerManager().getUsage() - 1);
            }
        }
    }

    @EventHandler
    public void onDoorUse(DoorUseEvent event){
        if(Fnaf.getInstance().getGame().inProgress()){
            if(!event.isOpen()){
                Fnaf.getInstance().getPowerManager().setUsage(Fnaf.getInstance().getPowerManager().getUsage() + 1);
            } else{
                Fnaf.getInstance().getPowerManager().setUsage(Fnaf.getInstance().getPowerManager().getUsage() - 1);
            }
        }
    }

    @EventHandler
    public void onLightUse(LightUseEvent event){
        if(Fnaf.getInstance().getGame().inProgress()){
            if(event.isLit()){
                Fnaf.getInstance().getPowerManager().setUsage(Fnaf.getInstance().getPowerManager().getUsage() + 1);
            } else{
                Fnaf.getInstance().getPowerManager().setUsage(Fnaf.getInstance().getPowerManager().getUsage() - 1);
            }
        }
    }
}
