package me.majeek.fnaf.listeners;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.game.camera.CameraGui;
import me.majeek.fnaf.game.camera.CameraMovement;
import me.majeek.fnaf.game.camera.CameraOccupant;
import me.majeek.fnaf.game.characters.animatronic.AnimatronicLock;
import me.majeek.fnaf.game.characters.animatronic.FoxyCameraAttack;
import me.majeek.fnaf.game.characters.animatronic.AnimatronicVisible;
import me.majeek.fnaf.game.item.ItemKeep;
import me.majeek.fnaf.game.light.LightCancel;
import me.majeek.fnaf.game.power.PowerChangeUsage;
import me.majeek.fnaf.game.power.PowerIndicator;
import org.bukkit.event.Listener;

public class EventListener implements Listener {
    public EventListener(){
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new AnimatronicLock(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new CameraGui(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new CameraMovement(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new CameraOccupant(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new FoxyCameraAttack(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new ItemKeep(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new LightCancel(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new PowerChangeUsage(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new PowerIndicator(), Fnaf.getInstance());
        Fnaf.getInstance().getServer().getPluginManager().registerEvents(new AnimatronicVisible(), Fnaf.getInstance());
    }
}
