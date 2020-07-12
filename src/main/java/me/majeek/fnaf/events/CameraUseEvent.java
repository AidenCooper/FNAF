package me.majeek.fnaf.events;

import me.majeek.fnaf.game.camera.Camera;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CameraUseEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private Player player;
    private Camera from;
    private Camera to;

    public CameraUseEvent(Player player, Camera from, Camera to){
        this.player = player;
        this.from = from;
        this.to = to;
    }

    public Player getPlayer(){
        return player;
    }

    public Camera getFrom() {
        return from;
    }

    public Camera getTo() {
        return to;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
