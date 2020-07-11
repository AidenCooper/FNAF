package me.majeek.fnaf.game.item;

import me.majeek.fnaf.game.item.items.CameraItem;
import me.majeek.fnaf.game.item.items.LeftDoorItem;
import me.majeek.fnaf.game.item.items.RightDoorItem;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private List<Item> items = new ArrayList<>();

    public ItemManager(){
        items.add(new CameraItem());
        items.add(new LeftDoorItem());
        items.add(new RightDoorItem());
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItem(String name){
        for(Item item : items)
            if(item.getName().equalsIgnoreCase("name"))
                return item;
        return null;
    }
}
