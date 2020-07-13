package me.majeek.fnaf.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PowerChangeEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private double from;
    private double to;

    public PowerChangeEvent(double from, double to){
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
