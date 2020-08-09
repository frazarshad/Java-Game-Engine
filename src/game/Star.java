/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import components.AudioController;
import components.Collider;
import components.GameObject;
import components.StaticImage;

/**
 *
 * @author Fraz
 */
public class Star extends GameObject {

    public Star(int x, int y) {
        this.setLocation(x, y);
    }

    @Override
    public void start() {
        addAudioController(new AudioController());
        getAudioController().addAudio("death", "pacman/sound.wav");
        
        this.setSpriteRenderer(new StaticImage("pacman/star.png"));
        this.addCollider(new Collider(20, 20, true, false));
    }

    @Override
    public void onCollision(GameObject collider) {
        if (collider.getClass() == Pacman.class) {
            getAudioController().playOnce("death");
            ((Pacman)collider).addStar();
            this.delete();
        }
    }

}
