package me.majeek.fnaf.game.characters.animatronic;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.CameraUseEvent;
import me.majeek.fnaf.game.characters.animatronic.animatronics.Foxy;
import me.majeek.fnaf.game.characters.animatronic.animatronics.Freddy;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AnimatronicLock implements Listener {
    @EventHandler
    public void onCameraUse(CameraUseEvent event){
        if(Fnaf.getInstance().getGame().inProgress()){
            if(event.getFrom().getName().equalsIgnoreCase("OFFICE") && !event.getTo().getName().equalsIgnoreCase("OFFICE")){
                for(Animatronic animatronic : Fnaf.getInstance().getAnimatronicManager().getAnimatronics()){
                    if(animatronic instanceof Foxy){
                        ((Foxy) animatronic).setLocked(true);
                    } else if(animatronic instanceof Freddy){
                        ((Freddy) animatronic).setLocked(true);
                    }
                }
            } else if(!event.getFrom().getName().equalsIgnoreCase("OFFICE") && event.getTo().getName().equalsIgnoreCase("OFFICE")){
                for(Animatronic animatronic : Fnaf.getInstance().getAnimatronicManager().getAnimatronics()){
                    if(animatronic instanceof Foxy){
                        ((Foxy) animatronic).setLocked(false);
                    } else if(animatronic instanceof Freddy){
                        ((Freddy) animatronic).setLocked(false);
                    }
                }
            }
        }
    }
}
