package me.majeek.fnaf.game.camera;

import me.majeek.fnaf.game.camera.cameras.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CameraManager {
    private List<Camera> cameras = new ArrayList<>();

    public CameraManager(){
        cameras.add(new Office());
        cameras.add(new OneA());
        cameras.add(new OneB());
        cameras.add(new OneC());
        cameras.add(new TwoA());
        cameras.add(new TwoB());
        cameras.add(new Three());
        cameras.add(new FourA());
        cameras.add(new FourB());
        cameras.add(new Five());
        cameras.add(new Six());
        cameras.add(new Seven());
    }

    public List<Camera> getCameras(){
        return cameras;
    }

    public Camera getCamera(String name){
        for(Camera camera : cameras)
            if(camera.getName().equalsIgnoreCase(name))
                return camera;

        return null;
    }

    public void openGui(Player player){
        Inventory gui = Bukkit.createInventory(null, 54, ChatColor.RED + "Cameras");

        ItemStack empty = new ItemStack(Material.AIR);

        List<ItemStack> itemCameras = new ArrayList<>();
        HashMap<Integer, ItemStack> cameraIndex = new HashMap<>();

        List<ItemStack> menu = new ArrayList<>();

        for(Camera camera : cameras){
            ItemStack item = camera.getHead();
            ItemMeta itemMeta = item.getItemMeta();

            itemMeta.setDisplayName(camera.getName());
            itemMeta.setLocalizedName(camera.getName());

            item.setItemMeta(itemMeta);

            itemCameras.add(item);
        }

        cameraIndex.put(49, itemCameras.get(0));
        cameraIndex.put(4, itemCameras.get(1));
        cameraIndex.put(12, itemCameras.get(2));
        cameraIndex.put(20, itemCameras.get(3));
        cameraIndex.put(47, itemCameras.get(4));
        cameraIndex.put(38, itemCameras.get(5));
        cameraIndex.put(36, itemCameras.get(6));
        cameraIndex.put(51, itemCameras.get(7));
        cameraIndex.put(42, itemCameras.get(8));
        cameraIndex.put(9, itemCameras.get(9));
        cameraIndex.put(35, itemCameras.get(10));
        cameraIndex.put(17, itemCameras.get(11));

        for(int i = 0; i < 54; i++){
            if(cameraIndex.containsKey(i))
                menu.add(cameraIndex.get(i));
            else
                menu.add(empty);
        }

        gui.setContents(menu.toArray(new ItemStack[menu.size()]));
        player.openInventory(gui);
    }
}
