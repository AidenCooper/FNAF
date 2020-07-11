package me.majeek.fnaf.listeners;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.game.item.ItemEvents;
import org.bukkit.event.Listener;

public class EventListener implements Listener {
    public EventListener(){
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new ItemEvents(), Fnaf.getInstance());
    }
}
