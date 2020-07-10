package me.majeek.fnaf.game.characters.animatronic;

import org.bukkit.entity.Player;

public class Animatronic {
    private String name;

    private Player player;

    public Animatronic(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public void toSpawn() {}

    public void getItems(){}
}
