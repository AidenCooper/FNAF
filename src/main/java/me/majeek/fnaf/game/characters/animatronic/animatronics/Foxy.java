package me.majeek.fnaf.game.characters.animatronic.animatronics;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import me.majeek.fnaf.game.characters.animatronic.PirateCove;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class Foxy extends Animatronic {
    public Foxy() {
        super("Foxy", 20, Color.fromRGB(92, 25, 20), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzdhN2M5YTM5M2I4YmRmYjQ0YTc5MWU2OTA5M2Y2NGZiNTY4ZThmZTZjZjQ2M2ZlZGQ4ZmVmZDMxN2Q2ZDMyIn19fQ==");
    }

    @Override
    public void start() {
        new BukkitRunnable() {
            @Override
            public void run() {
                int random = (int) (Math.random() * 19 + 1);

                if(getLevel() >= random){
                    move();
                }
            }
        }.runTaskTimer(Fnaf.getInstance(), 101L, 101L);
    }

    @Override
    public void move() {
        List<Location> position = new ArrayList<>();

        Location clone = getSpawn().clone();
        position.add(clone);

        clone.set(114.5, 4.5, 31.5);
        clone.setYaw(118);
        clone.setPitch(-11);
        position.add(clone);

        clone.set(114.5, 4.5, 30.5);
        clone.setYaw(110);
        clone.setPitch(-13);
        position.add(clone);

        Bukkit.broadcastMessage("Test");
        for(int i = 0; i < position.size(); i++){
            Bukkit.broadcastMessage("Test1");
            if(position.get(i) == getArmorStand().getLocation()){
                Bukkit.broadcastMessage("Test2");
                if(i + 1 < position.size()){
                    Bukkit.broadcastMessage("Test3");
                    PirateCove.open();
                    getArmorStand().teleport(position.get(i + 1));
                } else{
                    Bukkit.broadcastMessage("Test4");
                    attack();
                }
            }
        }
    }

    @Override
    public void attack() {

    }
}
