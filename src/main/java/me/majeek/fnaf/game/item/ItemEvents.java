package me.majeek.fnaf.game.item;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.door.Door;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemEvents implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null && event.getItem().getItemMeta() != null) {
                switch (event.getItem().getItemMeta().getLocalizedName()){
                    case "Camera":
                        camera();
                        break;
                    case "Left Door":
                        leftDoor();
                        break;
                    case "Right Door":
                        rightDoor();
                        break;
                }
            }
        }
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event){
        for(Item item : Fnaf.getInstance().getItemManager().getItems())
            if(event.getItemDrop().getItemStack().getItemMeta().getLocalizedName().equalsIgnoreCase(item.getItem().getItemMeta().getLocalizedName()))
                event.setCancelled(true);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event){
        if(event.getCurrentItem() != null && event.getCurrentItem().getItemMeta() != null){
            for(Item item : Fnaf.getInstance().getItemManager().getItems())
                if(event.getCurrentItem().getItemMeta().getLocalizedName().equalsIgnoreCase(item.getItem().getItemMeta().getLocalizedName()))
                    event.setCancelled(true);
        }
    }

    private void camera(){

    }

    private void leftDoor(){
        Door leftDoor = Fnaf.getInstance().getDoorManager().getDoor("Left Door");

        if(leftDoor.isClosed()){
            leftDoor.open();
        } else{
            leftDoor.close();
        }
    }

    private void rightDoor(){
        Door rightDoor = Fnaf.getInstance().getDoorManager().getDoor("Right Door");

        if(rightDoor.isClosed()){
            rightDoor.open();
        } else{
            rightDoor.close();
        }
    }
}
