package me.majeek.fnaf.game.camera;

import me.majeek.fnaf.Fnaf;
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
                        if(camera.isEnabled()) {
                            camera.useCamera((Player) event.getWhoClicked());
                        } else{
                            event.getWhoClicked().sendMessage(ChatColor.RED + "[" + camera.getName() + "] Camera is disabled.");
                            event.getWhoClicked().closeInventory();
                        }

                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
