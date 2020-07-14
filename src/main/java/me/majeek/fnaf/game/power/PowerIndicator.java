package me.majeek.fnaf.game.power;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.PowerChangeEvent;
import me.majeek.fnaf.game.characters.Guard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PowerIndicator implements Listener {
    @EventHandler
    public void onPowerChange(PowerChangeEvent event){
        if(Fnaf.getInstance().getGame().inProgress()){
            Guard guard = Fnaf.getInstance().getDataManager().getGuard();
            int level = (int) (Math.floor(event.getTo()));

            if(guard.getPlayer().getLevel() != level)
                Fnaf.getInstance().getExpManager().setTotalExperience(guard.getPlayer(), Fnaf.getInstance().getExpManager().getTotalExpAtLevel(level));
        }
    }
}
