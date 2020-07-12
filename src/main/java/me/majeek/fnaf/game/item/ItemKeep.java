package me.majeek.fnaf.game.item;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.Camera;
import me.majeek.fnaf.game.door.Door;
import me.majeek.fnaf.game.light.Light;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class ItemKeep implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null && event.getItem().getItemMeta() != null) {
                switch (event.getItem().getItemMeta().getLocalizedName()){
                    case "Camera":
                        camera(event.getPlayer());
                        break;
                    case "Left Door":
                        leftDoor();
                        break;
                    case "Right Door":
                        rightDoor();
                        break;
                    case "Left Light":
                        leftLight();
                        break;
                    case "Right Light":
                        rightLight();
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

    private void camera(Player player){
        Fnaf.getInstance().getCameraManager().openGui(player);
    }

    private void leftDoor(){
        if(!Fnaf.getInstance().getCameraManager().getCamera("OFFICE").isOccupied() || !Fnaf.getInstance().getCameraManager().getCamera("OFFICE").getOccupant().getName().equalsIgnoreCase(Fnaf.getInstance().getDataManager().getGuard().getPlayer().getName())){
            return;
        }

        Door leftDoor = Fnaf.getInstance().getDoorManager().getDoor("Left Door");

        if(leftDoor.isClosed()){
            leftDoor.open();
        } else{
            leftDoor.close();
        }
    }

    private void rightDoor(){
        if(!Fnaf.getInstance().getCameraManager().getCamera("OFFICE").isOccupied() || !Fnaf.getInstance().getCameraManager().getCamera("OFFICE").getOccupant().getName().equalsIgnoreCase(Fnaf.getInstance().getDataManager().getGuard().getPlayer().getName())){
            return;
        }

        Door rightDoor = Fnaf.getInstance().getDoorManager().getDoor("Right Door");

        if(rightDoor.isClosed()){
            rightDoor.open();
        } else{
            rightDoor.close();
        }
    }

    private void leftLight(){
        if(!Fnaf.getInstance().getCameraManager().getCamera("OFFICE").isOccupied() || !Fnaf.getInstance().getCameraManager().getCamera("OFFICE").getOccupant().getName().equalsIgnoreCase(Fnaf.getInstance().getDataManager().getGuard().getPlayer().getName())){
            return;
        }

        Light leftLight = Fnaf.getInstance().getLightManager().getLight("Left Light");

        if(leftLight.isLit()){
            leftLight.unLight();
        } else{
            leftLight.light();
        }
    }

    private void rightLight(){
        if(!Fnaf.getInstance().getCameraManager().getCamera("OFFICE").isOccupied() || !Fnaf.getInstance().getCameraManager().getCamera("OFFICE").getOccupant().getName().equalsIgnoreCase(Fnaf.getInstance().getDataManager().getGuard().getPlayer().getName())){
            return;
        }

        Light rightLight = Fnaf.getInstance().getLightManager().getLight("Right Light");

        if(rightLight.isLit()){
            rightLight.unLight();
        } else{
            rightLight.light();
        }
    }
}
