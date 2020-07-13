package me.majeek.fnaf.game.power;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.PowerChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PowerManager {
    private double totalPower;
    private int usage;

    public void start(){
        totalPower = 100;
        usage = 1;

        Fnaf.getInstance().getExpManager().setTotalExperience(Fnaf.getInstance().getDataManager().getGuard().getPlayer(), Fnaf.getInstance().getExpManager().getTotalExpAtLevel(100)); // 21310

        new BukkitRunnable() {
            @Override
            public void run() {
                if(Fnaf.getInstance().getGame().inProgress() && totalPower > 0){
                    switch(usage){
                        case 1:
                            Fnaf.getInstance().getServer().getPluginManager().callEvent(new PowerChangeEvent(totalPower, totalPower - 0.00520833335));
                            totalPower -= 0.00520833335; // 1 power = 9.6 seconds
                            break;
                        case 2:
                            Fnaf.getInstance().getServer().getPluginManager().callEvent(new PowerChangeEvent(totalPower, totalPower - 0.0104166667));
                            totalPower -= 0.0104166667; // 1 power = 4.8 seconds
                            break;
                        case 3:
                            Fnaf.getInstance().getServer().getPluginManager().callEvent(new PowerChangeEvent(totalPower, totalPower - 0.015625));
                            totalPower -= 0.015625; // 1 power = 3.2 seconds
                            break;
                        default:
                            Fnaf.getInstance().getServer().getPluginManager().callEvent(new PowerChangeEvent(totalPower, totalPower - 0.0208333333));
                            totalPower -= 0.0208333333; // 1 power = 2.4 seconds
                    }
                } else{
                    cancel();
                }
            }
        }.runTaskTimer(Fnaf.getInstance(), 1L, 1L);
    }

    public double getTotalPower() {
        return totalPower;
    }

    public int getUsage(){
        return usage;
    }

    public void setTotalPower(int totalPower) {
        this.totalPower = totalPower;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }
}
