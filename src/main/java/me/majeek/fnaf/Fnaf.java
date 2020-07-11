package me.majeek.fnaf;

import me.majeek.fnaf.game.Game;
import me.majeek.fnaf.game.camera.CameraManager;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.characters.animatronic.AnimatronicManager;
import me.majeek.fnaf.game.data.DataManager;
import me.majeek.fnaf.game.door.DoorManager;
import me.majeek.fnaf.game.item.ItemManager;
import me.majeek.fnaf.listeners.CommandListener;
import me.majeek.fnaf.listeners.EventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Fnaf extends JavaPlugin {
    private static Fnaf instance;

    private Game game;
    private AnimatronicManager animatronicManager;
    private CameraManager cameraManager;
    private DataManager dataManager;
    private DoorManager doorManager;
    private ItemManager itemManager;

    @Override
    public void onEnable() {
        // Instance
        instance = this;

        // Configs
        FnafConfig.setup();
        FnafConfig.get().options().copyDefaults(true);
        FnafConfig.save();

        // Managers
        game = new Game();
        animatronicManager = new AnimatronicManager();
        cameraManager = new CameraManager();
        dataManager = new DataManager();
        doorManager = new DoorManager();
        itemManager = new ItemManager();

        // Listeners
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getCommand("fnaf").setExecutor(new CommandListener());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Fnaf getInstance(){
        return instance;
    }

    public Game getGame(){
        return game;
    }

    public AnimatronicManager getAnimatronicManager(){
        return animatronicManager;
    }

    public CameraManager getCameraManager(){
        return cameraManager;
    }

    public DataManager getDataManager(){
        return dataManager;
    }

    public DoorManager getDoorManager() {
        return doorManager;
    }

    public ItemManager getItemManager(){
        return itemManager;
    }
}
