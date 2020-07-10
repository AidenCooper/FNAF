package me.majeek.fnaf.game.characters.animatronic;

import me.majeek.fnaf.game.characters.animatronic.animatronics.Bonnie;
import me.majeek.fnaf.game.characters.animatronic.animatronics.Chica;
import me.majeek.fnaf.game.characters.animatronic.animatronics.Foxy;
import me.majeek.fnaf.game.characters.animatronic.animatronics.Freddy;

import java.util.ArrayList;
import java.util.List;

public class AnimatronicManager {
    private List<Animatronic> animatronics = new ArrayList<>();

    public AnimatronicManager(){
        animatronics.add(new Bonnie());
        animatronics.add(new Chica());
        animatronics.add(new Foxy());
        animatronics.add(new Freddy());
    }

    public List<Animatronic> getAnimatronics() {
        return animatronics;
    }
}
