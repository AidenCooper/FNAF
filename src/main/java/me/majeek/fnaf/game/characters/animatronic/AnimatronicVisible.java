package me.majeek.fnaf.game.characters.animatronic;

import com.mojang.datafixers.util.Pair;
import me.majeek.fnaf.events.AnimatronicVisibleEvent;
import net.minecraft.server.v1_16_R1.EnumItemSlot;
import net.minecraft.server.v1_16_R1.PacketPlayOutEntityEquipment;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_16_R1.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Arrays;

public class AnimatronicVisible implements Listener {
    @EventHandler
    public void onAnimatronicVisible(AnimatronicVisibleEvent event){
        if(event.isVisible()){
            event.getAnimatronic().getArmorStand().setVisible(true);

            PacketPlayOutEntityEquipment helmet = new PacketPlayOutEntityEquipment(event.getAnimatronic().getArmorStand().getEntityId(), Arrays.asList(new Pair<>(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(event.getAnimatronic().getArmorStand().getHelmet()))));
            PacketPlayOutEntityEquipment chestplate = new PacketPlayOutEntityEquipment(event.getAnimatronic().getArmorStand().getEntityId(), Arrays.asList(new Pair<>(EnumItemSlot.CHEST, CraftItemStack.asNMSCopy(event.getAnimatronic().getArmorStand().getChestplate()))));
            PacketPlayOutEntityEquipment leggings = new PacketPlayOutEntityEquipment(event.getAnimatronic().getArmorStand().getEntityId(), Arrays.asList(new Pair<>(EnumItemSlot.LEGS, CraftItemStack.asNMSCopy(event.getAnimatronic().getArmorStand().getLeggings()))));
            PacketPlayOutEntityEquipment boots = new PacketPlayOutEntityEquipment(event.getAnimatronic().getArmorStand().getEntityId(), Arrays.asList(new Pair<>(EnumItemSlot.FEET, CraftItemStack.asNMSCopy(event.getAnimatronic().getArmorStand().getBoots()))));

            for (Player player : Bukkit.getOnlinePlayers()) {
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(helmet);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(chestplate);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(leggings);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(boots);
            }
        } else{
            event.getAnimatronic().getArmorStand().setVisible(false);

            PacketPlayOutEntityEquipment helmet = new PacketPlayOutEntityEquipment(event.getAnimatronic().getArmorStand().getEntityId(), Arrays.asList(new Pair<>(EnumItemSlot.HEAD, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.AIR)))));
            PacketPlayOutEntityEquipment chestplate = new PacketPlayOutEntityEquipment(event.getAnimatronic().getArmorStand().getEntityId(), Arrays.asList(new Pair<>(EnumItemSlot.CHEST, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.AIR)))));
            PacketPlayOutEntityEquipment leggings = new PacketPlayOutEntityEquipment(event.getAnimatronic().getArmorStand().getEntityId(), Arrays.asList(new Pair<>(EnumItemSlot.LEGS, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.AIR)))));
            PacketPlayOutEntityEquipment boots = new PacketPlayOutEntityEquipment(event.getAnimatronic().getArmorStand().getEntityId(), Arrays.asList(new Pair<>(EnumItemSlot.FEET, CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.AIR)))));

            for (Player player : Bukkit.getOnlinePlayers()) {
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(helmet);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(chestplate);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(leggings);
                ((CraftPlayer) player).getHandle().playerConnection.sendPacket(boots);
            }
        }
    }
}
