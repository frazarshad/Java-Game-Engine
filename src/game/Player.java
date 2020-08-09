/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import components.Animation;
import components.AnimationController;
import components.AudioController;
import components.Collider;
import components.GameObject;
import java.awt.event.KeyEvent;

/**
 *
 * @author Fraz
 */
public class Player extends GameObject {

    private int speed = 5;

    @Override
    public void start() {
        AnimationController controller = new AnimationController();
        controller.addAnimation(
                "main",
                new Animation(
                        "test1.png",
                        "test2.png",
                        "test3.png"
                )
        );
        controller.addAnimation(
                "second",
                new Animation(
                        4,
                        "test1.png",
                        "test2.png",
                        "test3.png"
                )
        );
        this.setSpriteRenderer(controller);
        this.setLocation(400, 300);
        
        AudioController audio = new AudioController();
        audio.addAudio("jump", "sound.wav");
        
        this.addAudioController(audio);
        this.addCollider(new Collider(40, 40, false, true));
    }
    
    @Override
    public void onKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.getSpriteRenderer().changeAnimation("main");
                this.setLocation(this.getX(), this.getY() - speed);
                break;
            case KeyEvent.VK_DOWN:
                this.getSpriteRenderer().changeAnimation("main");
                this.setLocation(this.getX(), this.getY() + speed);
                break;
            case KeyEvent.VK_LEFT:
                this.getSpriteRenderer().changeAnimation("second");
                this.setLocation(this.getX() - speed, this.getY());
                break;
            case KeyEvent.VK_RIGHT:
                this.getSpriteRenderer().changeAnimation("second");
                this.setLocation(this.getX() + speed, this.getY());
                break;
        }
    }

    @Override
    public void onKeyDown(KeyEvent e) {
            this.getAudioController().playOnce("jump");
    }
    
    
    
}
