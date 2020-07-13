package me.majeek.fnaf.game;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.camera.CameraManager;
import me.majeek.fnaf.game.characters.Guard;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import me.majeek.fnaf.game.characters.animatronic.AnimatronicManager;
import me.majeek.fnaf.game.data.DataManager;
import me.majeek.fnaf.game.door.Door;
import me.majeek.fnaf.game.door.DoorManager;
import me.majeek.fnaf.game.exp.ExpManager;
import me.majeek.fnaf.game.item.ItemManager;
import me.majeek.fnaf.game.light.Light;
import me.majeek.fnaf.game.light.LightManager;
import me.majeek.fnaf.game.power.PowerManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private boolean inProgress;
    private boolean isInitialized;

    public void start(){
        inProgress = true;

        final World world = Fnaf.getInstance().getDataManager().getWorld();
        final Guard guard = Fnaf.getInstance().getDataManager().getGuard();
        final List<Animatronic> animatronics = Fnaf.getInstance().getDataManager().getAnimatronics();

        guard.toSpawn();
        guard.getPlayer().getInventory().clear();
        guard.getPlayer().setGameMode(GameMode.ADVENTURE);
        guard.getItems();

        for(Animatronic animatronic : animatronics) {
            animatronic.spawn();
        }

        Fnaf.getInstance().getTimeManager().start();
        Fnaf.getInstance().getPowerManager().start();
    }

    public void stop(){
        inProgress = false;
        reset();
    }

    private void reset(){
        List<Player> players = new ArrayList<>();

        if(Fnaf.getInstance().getDataManager().getGuard() != null && Fnaf.getInstance().getDataManager().getGuard().getPlayer() != null)
            players.add(Fnaf.getInstance().getDataManager().getGuard().getPlayer());

        if(Fnaf.getInstance().getDataManager().getAnimatronics() != null)
            for (Animatronic animatronic : Fnaf.getInstance().getDataManager().getAnimatronics())
                animatronic.remove();

        for (Player player : players) {
            player.getInventory().clear();
            player.setGameMode(GameMode.ADVENTURE);
            player.teleport(Fnaf.getInstance().getDataManager().getWorld().getSpawnLocation());
        }

        for(Door door : Fnaf.getInstance().getDoorManager().getDoors())
            door.open();

        for(Light light : Fnaf.getInstance().getLightManager().getLights())
            light.unLight();

        Fnaf.getInstance().getExpManager().setTotalExperience(Fnaf.getInstance().getDataManager().getGuard().getPlayer(), 0);

        Fnaf.getInstance().setAnimatronicManager(new AnimatronicManager());
        Fnaf.getInstance().setCameraManager(new CameraManager());
        Fnaf.getInstance().setDataManager(new DataManager());
        Fnaf.getInstance().setDoorManager(new DoorManager());
        Fnaf.getInstance().setExpManager(new ExpManager());
        Fnaf.getInstance().setItemManager(new ItemManager());
        Fnaf.getInstance().setLightManager(new LightManager());
        Fnaf.getInstance().setPowerManager(new PowerManager());
    }

    public void initialize(Player player){
        World world = Bukkit.getWorld(FnafConfig.get().getString("world"));
        Guard guard = new Guard(player);
        List<Animatronic> animatronics = new ArrayList<>(Fnaf.getInstance().getAnimatronicManager().getAnimatronics());

        if(world != null) {
            Fnaf.getInstance().getDataManager().setWorld(world);
            Fnaf.getInstance().getDataManager().setGuard(guard);
            Fnaf.getInstance().getDataManager().setAnimatronics(animatronics);

            isInitialized = true;
        }
    }

    public boolean isInitialized() {
        return isInitialized;
    }

    public boolean inProgress(){
        return inProgress;
    }
}
