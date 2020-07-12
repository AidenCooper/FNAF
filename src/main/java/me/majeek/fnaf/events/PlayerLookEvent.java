package me.majeek.fnaf.events;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerLookEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private Player player;
    private Location to;

    public PlayerLookEvent(Player player, Location to){
        this.player = player;
        this.to = to;
    }

    public Player getPlayer() {
        return player;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to){
        this.to = to;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
