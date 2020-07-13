package me.majeek.fnaf.game.characters.animatronic;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import me.majeek.fnaf.files.FnafConfig;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.nio.ByteBuffer;
import java.util.UUID;

public class Animatronic {
    private String name;
    private Color color;
    private String headTexture;

    private ArmorStand armorStand;

    public Animatronic(String name, Color color, String headTexture){
        this.name = name;
        this.color = color;
        this.headTexture = headTexture;
    }

    public String getName(){
        return name;
    }

    public Color getColor(){
        return color;
    }

    public String getHeadTexture() {
        return headTexture;
    }

    public Location getSpawn() {
        return new Location(Bukkit.getWorld(FnafConfig.get().getString("world")), FnafConfig.get().getDouble("animatronics." + name.toLowerCase() + ".spawn.x"), FnafConfig.get().getDouble("animatronics." + name.toLowerCase() + ".spawn.y"), FnafConfig.get().getDouble("animatronics." + name.toLowerCase() + ".spawn.z"), (float) FnafConfig.get().getDouble("animatronics." + name.toLowerCase() + ".spawn.yaw"), (float) FnafConfig.get().getDouble("animatronics." + name.toLowerCase() + ".spawn.pitch"));
    }

    @SuppressWarnings("deprecation")
    public void spawn(){
        if(armorStand == null) {
            armorStand = getSpawn().getWorld().spawn(getSpawn(), ArmorStand.class);

            armorStand.setCustomName(name);
            armorStand.setCustomNameVisible(false);
            armorStand.setInvulnerable(true);
            armorStand.setArms(true);

            ItemStack head = getHead();
            ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
            ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
            ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);

            LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
            LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) leggings.getItemMeta();
            LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();

            chestplateMeta.setColor(color);
            leggingsMeta.setColor(color);
            bootsMeta.setColor(color);

            chestplate.setItemMeta(chestplateMeta);
            leggings.setItemMeta(leggingsMeta);
            boots.setItemMeta(bootsMeta);

            armorStand.setHelmet(head);
            armorStand.setChestplate(chestplate);
            armorStand.setLeggings(leggings);
            armorStand.setBoots(boots);
        }
    }

    public void remove(){
        if(armorStand != null){
            armorStand.remove();
            armorStand = null;
        }
    }

    @SuppressWarnings("deprecation")
    private ItemStack getHead(){
        UUID id = UUID.nameUUIDFromBytes(headTexture.getBytes());
        int less = (int) id.getLeastSignificantBits();
        int most = (int) id.getMostSignificantBits();
        return Bukkit.getUnsafe().modifyItemStack(
                new ItemStack(Material.PLAYER_HEAD),
                "{SkullOwner:{Id:[I;" + (less * most) + "," + (less >> 23) + "," + (most / less) + "," + (most * 8731) + "],Properties:{textures:[{Value:\"" + headTexture + "\"}]}}}"
        );
    }

    private static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }
}