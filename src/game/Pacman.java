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
import java.awt.event.KeyEvent;

/**
 *
 * @author Fraz
 */
public class Pacman extends GameObject {

    int speed = 3, xSpeed = 0, ySpeed = 0;
    int stars = 0;

    @Override
    public void start() {

        // Animation setup
        AnimationController anim = new AnimationController();

        Animation closedUp = new Animation(100, "pacman/closed_top.png", "pacman/open_top.png");
        anim.addAnimation("upMoving", closedUp);

        Animation closedDown = new Animation(100, "pacman/closed_bottom.png", "pacman/open_bottom.png");
        anim.addAnimation("downMoving", closedDown);

        Animation closedLeft = new Animation(100, "pacman/closed_left.png", "pacman/open_left.png");
        anim.addAnimation("leftMoving", closedLeft);

        Animation closedRight = new Animation(100, "pacman/closed_right.png", "pacman/open_right.png");
        anim.addAnimation("rightMoving", closedRight);

        Animation stillUp = new Animation("pacman/closed_top.png");
        anim.addAnimation("upStill", stillUp);

        Animation stillDown = new Animation("pacman/closed_bottom.png");
        anim.addAnimation("downStill", stillDown);

        Animation stillLeft = new Animation("pacman/closed_left.png");
        anim.addAnimation("leftStill", stillLeft);

        Animation stillRight = new Animation("pacman/closed_right.png");
        anim.addAnimation("rightStill", stillRight);

        this.setSpriteRenderer(anim);

        //location setup
        this.setLocation(24, 24);

        //Collider setup
        this.addCollider(new Collider(20, 20, false, true));

        //
    }

    @Override
    public void update() {
    }

    @Override
    public void onKeyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.getSpriteRenderer().changeAnimation("upMoving");
                this.setLocation(this.getX(), this.getY() - speed);
                break;
            case KeyEvent.VK_DOWN:
                this.getSpriteRenderer().changeAnimation("downMoving");
                this.setLocation(this.getX(), this.getY() + speed);
                break;
            case KeyEvent.VK_LEFT:
                this.getSpriteRenderer().changeAnimation("leftMoving");
                this.setLocation(this.getX() - speed, this.getY());
                break;
            case KeyEvent.VK_RIGHT:
                this.getSpriteRenderer().changeAnimation("rightMoving");
                this.setLocation(this.getX() + speed, this.getY());
                break;
        }
    }

    public void addStar() {
        stars++;
        if (stars >= 30) {
            getRenderEngine().stop();
        }
    }
}
