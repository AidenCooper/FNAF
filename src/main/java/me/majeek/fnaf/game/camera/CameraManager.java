package me.majeek.fnaf.game.camera;

import me.majeek.fnaf.game.camera.cameras.Office;
import me.majeek.fnaf.game.camera.cameras.OneA;
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
        Inventory gui = Bukkit.createInventory(null, 45, ChatColor.RED + "Cameras");

        ItemStack empty = new ItemStack(Material.AIR);

        List<ItemStack> itemCameras = new ArrayList<>();
        HashMap<Integer, ItemStack> cameraIndex = new HashMap<>();

        List<ItemStack> menu = new ArrayList<>();

        for(Camera camera : cameras){
            ItemStack item = new ItemStack(Material.COMPASS);
            ItemMeta itemMeta = item.getItemMeta();

            itemMeta.setDisplayName(camera.getName());
            itemMeta.setLocalizedName(camera.getName());

            item.setItemMeta(itemMeta);

            itemCameras.add(item);
        }

        cameraIndex.put(40, itemCameras.get(0));
        cameraIndex.put(4, itemCameras.get(1));

        for(int i = 0; i < 45; i++){
            if(cameraIndex.containsKey(i))
                menu.add(cameraIndex.get(i));
            else
                menu.add(empty);
        }

        gui.setContents(menu.toArray(new ItemStack[menu.size()]));
        player.openInventory(gui);
    }
}
