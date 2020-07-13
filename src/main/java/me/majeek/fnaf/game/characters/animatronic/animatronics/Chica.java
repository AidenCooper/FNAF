package me.majeek.fnaf.game.characters.animatronic.animatronics;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import org.bukkit.Color;
import org.bukkit.scheduler.BukkitRunnable;

public class Chica extends Animatronic {
    public Chica() {
        super("Chica", 2, Color.fromRGB(117, 90, 0), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzE0YWRmYzNkY2NlNmViMmM0NzE4NjUzZThhYTJjY2Y1ODVhM2MyYzczYmU0YjBhZGE5NjdlZTM2YmE3NTVlIn19fQ==");
    }

    @Override
    public void start() {
        new BukkitRunnable() {
            @Override
            public void run() {

            }
        }.runTaskTimer(Fnaf.getInstance(), 100L, 100L);
    }

    @Override
    public void move() {

    }
}
