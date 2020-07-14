package me.majeek.fnaf.game.characters.animatronic.animatronics;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import me.majeek.fnaf.game.characters.animatronic.PirateCove;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Foxy extends Animatronic {
    private boolean locked;
    private boolean canAttack;

    public Foxy() {
        super("Foxy", 20, Color.fromRGB(92, 25, 20), "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzdhN2M5YTM5M2I4YmRmYjQ0YTc5MWU2OTA5M2Y2NGZiNTY4ZThmZTZjZjQ2M2ZlZGQ4ZmVmZDMxN2Q2ZDMyIn19fQ==");
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
        } else{
            this.locked = true;
        }
    }

    public boolean canAttack(){
        return canAttack;
    }

    public void setCanAttack(boolean canAttack){
        this.canAttack = canAttack;
    }

    @Override
    public void start() {
        new BukkitRunnable() {
            int count;
            @Override
            public void run() {
                if(Fnaf.getInstance().getGame().inProgress()) {
                    if(isLocked() || canAttack)
                        count = 0;

                    if(count >= 101) {
                        int random = (int) (Math.random() * 19 + 1);

                        if (getLevel() >= random && !isLocked())
                            move();

                        count = 0;
                    }

                    count++;
                } else{
                    cancel();
                }
            }
        }.runTaskTimer(Fnaf.getInstance(), 0L, 1L);

        new BukkitRunnable() {
            int count;
            @Override
            public void run() {
                if(Fnaf.getInstance().getGame().inProgress()){
                    if(canAttack){
                        if(count >= 500){
                            attack();
                            canAttack = false;
                        }

                        count++;
                    } else{
                        count = 0;
                    }
                } else{
                    cancel();
                }
            }
        }.runTaskTimer(Fnaf.getInstance(), 0L, 1L);
    }

    @Override
    public void move() {
        List<Location> positions = new ArrayList<>();

        Location position = getSpawn().clone();
        Location position1 = getSpawn().clone().set(114.5, 4.5, 30.5);
        Location position2 = getSpawn().clone().set(113.25, 4.5, 30.75);

        position1.setYaw(110);
        position1.setPitch(-11);

        position2.setYaw(113);
        position2.setPitch(-11);

        positions.add(position);
        positions.add(position1);
        positions.add(position2);

        Vector standLocation = new Vector(getArmorStand().getLocation().getX(), getArmorStand().getLocation().getY(), getArmorStand().getLocation().getZ());

        for(int i = 0; i < positions.size(); i++){
            Vector positionLocation = new Vector(positions.get(i).getX(), positions.get(i).getY(), positions.get(i).getZ());

            if(standLocation.equals(positionLocation)){
                if(i + 2 < positions.size()){
                    PirateCove.open();
                    getArmorStand().teleport(positions.get(i + 1));
                } else if(i + 1 < positions.size()){
                    PirateCove.open();
                    getArmorStand().setHeadPose(new EulerAngle(0, 0, 80));
                    getArmorStand().teleport(positions.get(i + 1));
                } else{
                    setVisible(false);
                    canAttack = true;
                }

                break;
            }
        }
    }

    @Override
    public void attack() {
        Location position = new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 105.5, 4, 27.5, 180, 0);
        List<Location> positions;



        setVisible(true);
    }
}
