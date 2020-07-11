package me.majeek.fnaf.game.door;

import me.majeek.fnaf.game.door.doors.LeftDoor;
import me.majeek.fnaf.game.door.doors.RightDoor;

import java.util.ArrayList;
import java.util.List;

public class DoorManager {
    private List<Door> doors = new ArrayList<>();

    public DoorManager(){
        doors.add(new LeftDoor());
        doors.add(new RightDoor());
    }

    public List<Door> getDoors() {
        return doors;
    }

    public Door getDoor(String name){
        for(Door door : doors)
            if(door.getName().equalsIgnoreCase(name))
                return door;
        return null;
    }
}
