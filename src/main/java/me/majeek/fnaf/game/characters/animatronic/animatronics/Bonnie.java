package me.majeek.fnaf.game.characters.animatronic.animatronics;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import org.bukkit.Color;
import org.bukkit.scheduler.BukkitRunnable;

public class Bonnie extends Animatronic {
    public Bonnie() {
        super("Bonnie", 3, Color.fromRGB(67, 66, 112), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMWU1ZmZiMTEwZmZhNzg4NWNjMDM3MDVhNGQxYzczNGQ3NTM2MDYzY2EwYmZhYTA1Nzc1NDViYmE4ZDA1YzdiMiJ9fX0=");
    }

    @Override
    public void start() {
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimer(Fnaf.getInstance(), 99L, 99L);
    }

    @Override
    public void move() {

    }
}
