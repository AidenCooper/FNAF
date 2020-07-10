package me.majeek.fnaf.game.camera;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class Item implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.getItem() != null && event.getItem().getItemMeta() != null && event.getItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Compass")){
                Player player = event.getPlayer();

                Inventory gui = Bukkit.createInventory(player, 9, ChatColor.RED + "Camera");
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){
        if(event.getItemDrop().getItemStack().getItemMeta().getLocalizedName().equalsIgnoreCase("Camera")){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getCurrentItem() != null && event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase("Camera")){
            event.setCancelled(true);
        }
    }
}
