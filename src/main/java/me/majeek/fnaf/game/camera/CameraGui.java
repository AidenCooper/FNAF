package me.majeek.fnaf.game.camera;

import me.majeek.fnaf.Fnaf;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CameraGui implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Cameras")){
            if(event.getCurrentItem() != null){
                for(Camera camera : Fnaf.getInstance().getCameraManager().getCameras()){
                    if(event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase(camera.getName())){
                        camera.useCamera((Player) event.getWhoClicked());
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
