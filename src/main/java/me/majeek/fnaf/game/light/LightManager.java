package me.majeek.fnaf.game.light;

import me.majeek.fnaf.game.door.Door;
import me.majeek.fnaf.game.light.lights.LeftLight;
import me.majeek.fnaf.game.light.lights.RightLight;

import java.util.ArrayList;
import java.util.List;

public class LightManager {
    private List<Light> lights = new ArrayList<>();

    public LightManager(){
        lights.add(new LeftLight());
        lights.add(new RightLight());
    }

    public List<Light> getLights() {
        return lights;
    }

    public Light getLight(String name){
        for(Light light : lights)
            if(light.getName().equalsIgnoreCase(name))
                return light;
        return null;
    }
}
