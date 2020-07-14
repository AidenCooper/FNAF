package me.majeek.fnaf.game.characters.animatronic;

import me.majeek.fnaf.files.FnafConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class PirateCove {
    private static Location[] oneRow = { new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 113, 7, 30), new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), 113, 5, 30)};

    public static void open(){
        if(oneRow[0].getBlock().getType() != Material.AIR){
            for(int i = 0; i <= oneRow[0].getBlockY() - oneRow[1].getBlockY(); i++){
                new Location(oneRow[0].getWorld(), oneRow[0].getBlockX(), oneRow[0].getBlockY() - i, oneRow[0].getBlockZ()).getBlock().setType(Material.AIR);
            }
        }
    }

    public static void close(){
        for(int i = 0; i <= oneRow[0].getBlockY() - oneRow[1].getBlockY(); i++){
            new Location(oneRow[0].getWorld(), oneRow[0].getBlockX(), oneRow[0].getBlockY() - i, oneRow[0].getBlockZ()).getBlock().setType(Material.PURPLE_CONCRETE);
        }
    }
}
