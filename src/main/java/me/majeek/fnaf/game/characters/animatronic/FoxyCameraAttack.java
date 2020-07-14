package me.majeek.fnaf.game.characters.animatronic;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.CameraUseEvent;
import me.majeek.fnaf.game.camera.cameras.TwoA;
import me.majeek.fnaf.game.characters.animatronic.animatronics.Foxy;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FoxyCameraAttack implements Listener {
    @EventHandler
    public void onCameraUse(CameraUseEvent event){
        if(Fnaf.getInstance().getGame().inProgress()){
            if(event.getTo() instanceof TwoA) {
                for (Animatronic animatronic : Fnaf.getInstance().getAnimatronicManager().getAnimatronics()) {
                    if (animatronic instanceof Foxy && ((Foxy) animatronic).canAttack()) {
                        animatronic.attack();
                    }
                }
            }
        }
    }
}
