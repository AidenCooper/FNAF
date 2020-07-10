package me.majeek.fnaf.game;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.files.FnafConfig;
import me.majeek.fnaf.game.characters.Guard;
import me.majeek.fnaf.game.characters.animatronic.Animatronic;
import me.majeek.fnaf.game.characters.animatronic.animatronics.Bonnie;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private boolean inProgress;
    private boolean isInitialized;

    public Game() { }

    public void start(){
        inProgress = true;

        final World world = Fnaf.getInstance().getDataManager().getWorld();
        final Guard guard = Fnaf.getInstance().getDataManager().getGuard();
        final List<Animatronic> animatronics = Fnaf.getInstance().getDataManager().getAnimatronics();

        guard.toSpawn();
        guard.getPlayer().getInventory().clear();
        guard.getItems();

        for(Animatronic animatronic : animatronics) {
            animatronic.toSpawn();
            animatronic.getPlayer().getInventory().clear();
        }
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
            for (int i = 0; i < Fnaf.getInstance().getDataManager().getAnimatronics().size(); i++)
                players.add(Fnaf.getInstance().getDataManager().getAnimatronics().get(i).getPlayer());

        for (Player player : players) {
            if(player != null && player.getInventory().getSize() > 0) {
                player.getInventory().clear();
                player.teleport(Fnaf.getInstance().getDataManager().getWorld().getSpawnLocation());
            }
        }

        Fnaf.getInstance().getDataManager().setWorld(null);
        Fnaf.getInstance().getDataManager().setGuard(null);
        Fnaf.getInstance().getDataManager().setAnimatronics(null);
    }

    public void initialize(){
        World world = Bukkit.getWorld(FnafConfig.get().getString("world"));
        Guard guard = null;
        List<Animatronic> animatronics = new ArrayList<>();

        if(world != null && world.getPlayerCount() >= 2){
            List<Player> worldPlayers = world.getPlayers();

            int randomNumber = (int) (Math.random() * worldPlayers.size());

            guard = new Guard(worldPlayers.get(randomNumber));
            worldPlayers.remove(randomNumber);

            List<Animatronic> animatronicList = Fnaf.getInstance().getAnimatronicManager().getAnimatronics();

            for(int i = 0; i < worldPlayers.size(); i++){
                if(i < Fnaf.getInstance().getAnimatronicManager().getAnimatronics().size()){
                    randomNumber = (int) (Math.random() * animatronicList.size());

                    animatronicList.get(randomNumber).setPlayer(worldPlayers.get(i));
                    animatronics.add(animatronicList.get(randomNumber));
                    animatronicList.remove(randomNumber);
                } else{
                    break;
                }
            }
        }

        if(world != null && guard != null && animatronics.size() > 0) {
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
