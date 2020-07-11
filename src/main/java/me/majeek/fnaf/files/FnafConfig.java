package me.majeek.fnaf.files;

import me.majeek.fnaf.Fnaf;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FnafConfig {
    private static File file;
    private static FileConfiguration fnafConfig;

    public static void setup(){
        file = new File(Fnaf.getInstance().getDataFolder(), "fnaf.yml");

        if(!file.exists()){
            try { file.createNewFile(); }
            catch (IOException e){}
        }

        fnafConfig = YamlConfiguration.loadConfiguration(file);

        fnafConfig.addDefault("world", "fnaf");

        fnafConfig.addDefault("office.spawn.x", 100.5);
        fnafConfig.addDefault("office.spawn.y", 4);
        fnafConfig.addDefault("office.spawn.z", 13.5);
        fnafConfig.addDefault("office.spawn.yaw", 0);
        fnafConfig.addDefault("office.spawn.pitch", 0);

        fnafConfig.addDefault("office.doors.left.material", "STONE");
        fnafConfig.addDefault("office.doors.left.x", 103);
        fnafConfig.addDefault("office.doors.left.y", 4);
        fnafConfig.addDefault("office.doors.left.z", 16);

        fnafConfig.addDefault("office.doors.right.material", "STONE");
        fnafConfig.addDefault("office.doors.right.x", 97);
        fnafConfig.addDefault("office.doors.right.y", 4);
        fnafConfig.addDefault("office.doors.right.z", 16);

        fnafConfig.addDefault("animatronics.bonnie.spawn.x", 102.5);
        fnafConfig.addDefault("animatronics.bonnie.spawn.y", 4.5);
        fnafConfig.addDefault("animatronics.bonnie.spawn.z", 46.5);
        fnafConfig.addDefault("animatronics.bonnie.spawn.yaw", 180);
        fnafConfig.addDefault("animatronics.bonnie.spawn.pitch", 0);

        fnafConfig.addDefault("animatronics.chica.spawn.x", 98.5);
        fnafConfig.addDefault("animatronics.chica.spawn.y", 4.5);
        fnafConfig.addDefault("animatronics.chica.spawn.z", 46.5);
        fnafConfig.addDefault("animatronics.chica.spawn.yaw", 180);
        fnafConfig.addDefault("animatronics.chica.spawn.pitch", 0);

        fnafConfig.addDefault("animatronics.foxy.spawn.x", 100.5);
        fnafConfig.addDefault("animatronics.foxy.spawn.y", 4.5);
        fnafConfig.addDefault("animatronics.foxy.spawn.z", 46.5);
        fnafConfig.addDefault("animatronics.foxy.spawn.yaw", 180);
        fnafConfig.addDefault("animatronics.foxy.spawn.pitch", 0);

        fnafConfig.addDefault("animatronics.freddy.spawn.x", 100.5);
        fnafConfig.addDefault("animatronics.freddy.spawn.y", 4.5);
        fnafConfig.addDefault("animatronics.freddy.spawn.z", 46.5);
        fnafConfig.addDefault("animatronics.freddy.spawn.yaw", 0);
        fnafConfig.addDefault("animatronics.freddy.spawn.pitch", 180);
    }

    public static FileConfiguration get(){
        return fnafConfig;
    }

    public static void save(){
        try { fnafConfig.save(file); }
        catch (IOException e){}
    }

    public static void reload(){
        fnafConfig = YamlConfiguration.loadConfiguration(file);
    }
}
