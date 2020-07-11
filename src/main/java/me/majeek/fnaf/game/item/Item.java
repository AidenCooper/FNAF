package me.majeek.fnaf.game.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Item {
    private String name;
    private Material material;

    public Item(String name, Material material){
        this.name = name;
        this.material = material;
    }

    public String getName(){
        return name;
    }

    public Material getMaterial(){
        return material;
    }

    public ItemStack getItem(){
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLocalizedName(name);

        item.setItemMeta(meta);
        return item;
    }
}
