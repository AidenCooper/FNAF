package me.majeek.fnaf.game.time;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.TimeChangeEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class TimeManager {
    private int seconds;
    private int gameHour;

    public void start(){
        seconds = 0;
        gameHour = 12;

        Fnaf.getInstance().getServer().getPluginManager().callEvent(new TimeChangeEvent(0, gameHour));
        Fnaf.getInstance().getDataManager().getGuard().getPlayer().sendTitle("12 AM", "Night 1", 5, 40, 5);

        new BukkitRunnable() {
            @Override
            public void run() {
                seconds++;

                if(Fnaf.getInstance().getGame().inProgress()){
                    switch (gameHour) {
                        case 12:
                            if (seconds >= 90) {
                                seconds = 0;
                                gameHour = 1;

                                Fnaf.getInstance().getServer().getPluginManager().callEvent(new TimeChangeEvent(12, gameHour));
                                Fnaf.getInstance().getDataManager().getGuard().getPlayer().sendTitle("1 AM", "Night 1", 5, 40, 5);
                            }
                            break;
                        case 1:
                            if (seconds >= 89) {
                                seconds = 0;
                                gameHour = 2;

                                Fnaf.getInstance().getServer().getPluginManager().callEvent(new TimeChangeEvent(1, gameHour));
                                Fnaf.getInstance().getDataManager().getGuard().getPlayer().sendTitle("2 AM", "Night 1", 5, 40, 5);
                            }
                            break;
                        case 2:
                            if (seconds >= 89) {
                                seconds = 0;
                                gameHour = 3;

                                Fnaf.getInstance().getServer().getPluginManager().callEvent(new TimeChangeEvent(2, gameHour));
                                Fnaf.getInstance().getDataManager().getGuard().getPlayer().sendTitle("3 AM", "Night 1", 5, 40, 5);
                            }
                            break;
                        case 3:
                            if (seconds >= 89) {
                                seconds = 0;
                                gameHour = 4;

                                Fnaf.getInstance().getServer().getPluginManager().callEvent(new TimeChangeEvent(3, gameHour));
                                Fnaf.getInstance().getDataManager().getGuard().getPlayer().sendTitle("4 AM", "Night 1", 5, 40, 5);
                            }
                            break;
                        case 4:
                            if (seconds >= 89) {
                                seconds = 0;
                                gameHour = 5;

                                Fnaf.getInstance().getServer().getPluginManager().callEvent(new TimeChangeEvent(4, gameHour));
                                Fnaf.getInstance().getDataManager().getGuard().getPlayer().sendTitle("5 AM", "Night 1", 5, 40, 5);
                            }
                            break;
                        default:
                            if (seconds >= 89) {
                                seconds = 0;
                                gameHour = 6;

                                Fnaf.getInstance().getServer().getPluginManager().callEvent(new TimeChangeEvent(5, gameHour));
                                Fnaf.getInstance().getDataManager().getGuard().getPlayer().sendTitle("6 AM", "Night 1", 5, 40, 5);

                                cancel();
                            }
                    }
                } else{
                    cancel();
                }
            }
        }.runTaskTimer(Fnaf.getInstance(), 20L, 20L);
    }

    public int getSeconds() {
        return seconds;
    }

    public int getGameHour() {
        return gameHour;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void setGameHour(int gameHour) {
        this.gameHour = gameHour;
    }
}
