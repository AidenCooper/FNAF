package me.majeek.fnaf.events;

import me.majeek.fnaf.game.camera.Camera;
import me.majeek.fnaf.game.door.Door;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class DoorUseEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private Door door;
    private boolean open;

    public DoorUseEvent(Door door, boolean open){
        this.door = door;
        this.open = open;
    }

    public Door getDoor() {
        return door;
    }

    public boolean isOpen() {
        return open;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
