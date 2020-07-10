package me.majeek.fnaf.game.characters;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.files.FnafConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Guard {
    private Player player;

    public Guard(Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void toSpawn(){
        Location spawn = new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getDouble("office.spawn.x"), FnafConfig.get().getDouble("office.spawn.y"), FnafConfig.get().getDouble("office.spawn.z"), FnafConfig.get().getInt("office.spawn.yaw"), FnafConfig.get().getInt("office.spawn.pitch"));
        player.teleport(spawn);
    }

    public void getItems(){
        ItemStack camera = new ItemStack(Material.COMPASS);
        ItemMeta itemMeta = camera.getItemMeta();

        itemMeta.setDisplayName(ChatColor.DARK_RED + "Camera");
        itemMeta.setLocalizedName("Camera");

        camera.setItemMeta(itemMeta);

        player.getInventory().setItem(4, camera);
    }
}
