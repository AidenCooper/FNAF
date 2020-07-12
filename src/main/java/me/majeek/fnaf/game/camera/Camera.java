package me.majeek.fnaf.game.camera;

import me.majeek.fnaf.Fnaf;
import me.majeek.fnaf.events.CameraUseEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Camera {
    private String name;
    private Location location;
    private boolean enabled;

    private String headTexture;
    private Player occupant;

    public Camera(String name, Location location, boolean enabled){
        this.name = name;
        this.location = location;
        this.enabled = enabled;

        headTexture = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTQ0MjJhODJjODk5YTljMTQ1NDM4NGQzMmNjNTRjNGFlN2ExYzRkNzI0MzBlNmU0NDZkNTNiOGIzODVlMzMwIn19fQ==";
    }

    public String getName(){
        return name;
    }

    public Location getLocation(){
        return location;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void useCamera(Player player){
        boolean eventCalled = false;

        for (Camera camera : Fnaf.getInstance().getCameraManager().getCameras()) {
            if (camera.isOccupied()) {
                Fnaf.getInstance().getServer().getPluginManager().callEvent(new CameraUseEvent(player, camera, this));
                eventCalled = true;
            }
        }

        if (!eventCalled) {
            Fnaf.getInstance().getServer().getPluginManager().callEvent(new CameraUseEvent(player, null, this));
        }

        if (name.equalsIgnoreCase("OFFICE")) {
            player.showPlayer(Fnaf.getInstance(), player);
        } else {
            player.hidePlayer(Fnaf.getInstance(), player);
        }

        player.setSneaking(true);
        player.teleport(location);
    }

    @SuppressWarnings("deprecation")
    public ItemStack getHead(){
        UUID id = UUID.nameUUIDFromBytes(headTexture.getBytes());
        int less = (int) id.getLeastSignificantBits();
        int most = (int) id.getMostSignificantBits();
        return Bukkit.getUnsafe().modifyItemStack(
                new ItemStack(Material.PLAYER_HEAD),
                "{SkullOwner:{Id:[I;" + (less * most) + "," + (less >> 23) + "," + (most / less) + "," + (most * 8731) + "],Properties:{textures:[{Value:\"" + headTexture + "\"}]}}}"
        );
    }

    public Player getOccupant() {
        return occupant;
    }

    public void setOccupant(Player occupant) {
        this.occupant = occupant;
    }

    public boolean isOccupied(){
        if(occupant == null){
            return false;
        }

        return true;
    }
}
