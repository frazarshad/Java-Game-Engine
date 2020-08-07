/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import components.Animation;
import components.AnimationController;
import components.Collider;
import components.GameObject;
import components.KeyReader;
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
        
        addCollider(new Collider(40, 40));
    }
    
    @Override
    public void update() {
        
    }
    
    @Override
    public void onKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                spriteRenderer.changeAnimation("main");
                this.setLocation(this.getX(), this.getY() - speed);
                break;
            case KeyEvent.VK_DOWN:
                spriteRenderer.changeAnimation("main");
                this.setLocation(this.getX(), this.getY() + speed);
                break;
            case KeyEvent.VK_LEFT:
                spriteRenderer.changeAnimation("second");
                this.setLocation(this.getX() - speed, this.getY());
                break;
            case KeyEvent.VK_RIGHT:
                spriteRenderer.changeAnimation("second");
                this.setLocation(this.getX() + speed, this.getY());
                break;
        }
    }
    
}
