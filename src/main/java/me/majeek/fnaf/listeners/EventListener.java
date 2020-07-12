package me.majeek.fnaf.listeners;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.game.camera.CameraGui;
import me.majeek.fnaf.game.camera.CameraMovement;
import me.majeek.fnaf.game.camera.CameraOccupant;
import me.majeek.fnaf.game.item.ItemKeep;
import org.bukkit.event.Listener;

public class EventListener implements Listener {
    public EventListener(){
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new CameraGui(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new CameraMovement(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new CameraOccupant(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new ItemKeep(), Fnaf.getInstance());
    }
}
