package me.majeek.fnaf.game.characters;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.item.items.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
        Fnaf.getInstance().getCameraManager().getCamera("OFFICE").useCamera(player);
    }

    public void getItems(){
        ItemStack camera = new CameraItem().getItem();
        ItemStack leftDoor = new LeftDoorItem().getItem();
        ItemStack rightDoor = new RightDoorItem().getItem();
        ItemStack leftLight = new LeftLightItem().getItem();
        ItemStack rightLight = new RightLightItem().getItem();

        player.getInventory().setItem(4, camera);
        player.getInventory().setItem(0, leftDoor);
        player.getInventory().setItem(8, rightDoor);
        player.getInventory().setItem(1, leftLight);
        player.getInventory().setItem(7, rightLight);
    }
}
