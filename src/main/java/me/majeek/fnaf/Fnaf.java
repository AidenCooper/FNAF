package me.majeek.fnaf;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.majeek.fnaf.events.PlayerLookEvent;
import me.majeek.fnaf.game.Game;
import me.majeek.fnaf.game.camera.CameraManager;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.characters.animatronic.AnimatronicManager;
import me.majeek.fnaf.game.data.DataManager;
import me.majeek.fnaf.game.door.DoorManager;
import me.majeek.fnaf.game.item.ItemManager;
import me.majeek.fnaf.game.light.LightManager;
import me.majeek.fnaf.listeners.CommandListener;
import me.majeek.fnaf.listeners.EventListener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Fnaf extends JavaPlugin {
    private static Fnaf instance;

    private Game game;
    private AnimatronicManager animatronicManager;
    private CameraManager cameraManager;
    private DataManager dataManager;
    private DoorManager doorManager;
    private ItemManager itemManager;
    private LightManager lightManager;

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
        lightManager = new LightManager();

        // Listeners
        getServer().getPluginManager().registerEvents(new EventListener(), this);
        getCommand("fnaf").setExecutor(new CommandListener());

        // Packets
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(this, ListenerPriority.NORMAL, PacketType.Play.Client.LOOK) {@Override public void onPacketReceiving(PacketEvent event) { new BukkitRunnable() {@Override public void run() { Fnaf.getInstance().getServer().getPluginManager().callEvent(new PlayerLookEvent(event.getPlayer(), event.getPlayer().getLocation())); }}.runTask(Fnaf.getInstance()); }});
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

    public LightManager getLightManager(){
        return lightManager;
    }
}
