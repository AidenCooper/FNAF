package me.majeek.fnaf.events;

import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AnimatronicVisibleEvent extends Event {
    private static final HandlerList HANDLERS = new HandlerList();

    private Animatronic animatronic;
    private boolean visible;

    public AnimatronicVisibleEvent(Animatronic animatronic, boolean visible){
        this.animatronic = animatronic;
        this.visible = visible;
    }

    public Animatronic getAnimatronic() {
        return animatronic;
    }

    public boolean isVisible() {
        return visible;
    }

    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
