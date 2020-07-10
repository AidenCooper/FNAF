package me.majeek.fnaf.game.camera;

import java.util.ArrayList;
import java.util.List;

public class CameraManager {
    private List<Camera> cameras = new ArrayList<>();

    public CameraManager(){
        cameras.add(new OneA());
    }

    public List<Camera> getCameras(){
        return cameras;
    }
}
