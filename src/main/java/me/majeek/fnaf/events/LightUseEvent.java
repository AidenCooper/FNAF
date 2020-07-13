package me.majeek.fnaf.events;

import me.majeek.fnaf.game.light.Light;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LightUseEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private Light light;
    private boolean lit;

    public LightUseEvent(Light light, boolean lit){
        this.light = light;
        this.lit = lit;
    }

    public Light getLight() {
        return light;
    }

    public boolean isLit() {
        return lit;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
