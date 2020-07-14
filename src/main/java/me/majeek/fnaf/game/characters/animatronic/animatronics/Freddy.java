package me.majeek.fnaf.game.characters.animatronic.animatronics;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.scheduler.BukkitRunnable;

public class Freddy extends Animatronic {
    private boolean locked;

    public Freddy() {
        super("Freddy", 0, Color.fromRGB(88, 49, 19), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWUxNTEwMzE5MDc5MzVmZTc0ODMwYmQwZmZmZjQ2MzhiNjYxYzEwYmM5M2I3ZDJkZWNlNWU1NGY2Zjc0NWZlYiJ9fX0=");
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked1){
        if(!locked1){
            int random = (int) (Math.random() * 333 + 17); // ~0.83 - ~16.67 seconds

            new BukkitRunnable() {
                @Override
                public void run() {
                    if(Fnaf.getInstance().getGame().inProgress())
                        locked = false;
                    else
                        cancel();
                }
            }.runTaskLater(Fnaf.getInstance(), random);
        }
        else
            this.locked = true;
    }

    @Override
    public void start() {
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimer(Fnaf.getInstance(), 61L, 61L);
    }

    @Override
    public void move() {

    }
}
