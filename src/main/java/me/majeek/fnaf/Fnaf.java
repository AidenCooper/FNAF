package me.majeek.fnaf;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import me.majeek.fnaf.events.PlayerLookEvent;
import me.majeek.fnaf.game.exp.ExpManager;
import me.majeek.fnaf.game.Game;
import me.majeek.fnaf.game.camera.CameraManager;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.characters.animatronic.AnimatronicManager;
import me.majeek.fnaf.game.data.DataManager;
import me.majeek.fnaf.game.door.DoorManager;
import me.majeek.fnaf.game.item.ItemManager;
import me.majeek.fnaf.game.light.LightManager;
import me.majeek.fnaf.game.power.PowerManager;
import me.majeek.fnaf.game.time.TimeManager;
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
    private ExpManager expManager;
    private ItemManager itemManager;
    private LightManager lightManager;
    private PowerManager powerManager;
    private TimeManager timeManager;

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
        expManager = new ExpManager();
        itemManager = new ItemManager();
        lightManager = new LightManager();
        powerManager = new PowerManager();
        timeManager = new TimeManager();

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

    public ExpManager getExpManager() {
        return expManager;
    }

    public ItemManager getItemManager(){
        return itemManager;
    }

    public LightManager getLightManager(){
        return lightManager;
    }

    public PowerManager getPowerManager() {
        return powerManager;
    }

    public TimeManager getTimeManager() {
        return timeManager;
    }

    public void setAnimatronicManager(AnimatronicManager animatronicManager) {
        this.animatronicManager = animatronicManager;
    }

    public void setCameraManager(CameraManager cameraManager) {
        this.cameraManager = cameraManager;
    }

    public void setDataManager(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void setDoorManager(DoorManager doorManager) {
        this.doorManager = doorManager;
    }

    public void setExpManager(ExpManager expManager) {
        this.expManager = expManager;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void setLightManager(LightManager lightManager) {
        this.lightManager = lightManager;
    }

    public void setPowerManager(PowerManager powerManager) {
        this.powerManager = powerManager;
    }

    public void setTimeManager(TimeManager timeManager) {
        this.timeManager = timeManager;
    }
}
