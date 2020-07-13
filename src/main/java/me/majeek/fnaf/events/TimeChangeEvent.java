package me.majeek.fnaf.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TimeChangeEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private int from;
    private int to;

    public TimeChangeEvent(int from, int to){
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
