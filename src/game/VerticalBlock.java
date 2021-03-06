/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import components.Collider;
import components.GameObject;
import components.StaticImage;

/**
 *
 * @author Fraz
 */
public class VerticalBlock extends GameObject {

    public VerticalBlock(int x, int y) {
        this.setLocation(x, y);
    }

    @Override
    public void start() {
        this.addCollider(new Collider(20, 400, true, true));
        this.setSpriteRenderer(new StaticImage("pacman/block.png"));
    }

}
