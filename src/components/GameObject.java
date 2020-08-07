/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import util.Pair;

/**
 *
 * @author Fraz
 */
public class GameObject {
    
    protected SpriteRenderer spriteRenderer = null;
    protected Collider collider = null;
    protected Pair position;
    
    public GameObject () {
        position = new Pair(0, 0);
    }
    
    public GameObject (int x, int y) {
        position = new Pair(x, y);
    }
    
    public final void setLocation(int x, int y) {
        position.setPair(x, y);
    }
    
    public final int getX() {
        return position.getFirst();
    }
    
    public final int getY() {
        return position.getSecond();
    }

    public final BufferedImage getSprite() {
        if (spriteRenderer != null) {
            return spriteRenderer.getSprite();
        } else {
            return null;
        }
    } 
    
    public final void setSpriteRenderer(SpriteRenderer spriteRenderer) {
        this.spriteRenderer = spriteRenderer;
    }
    
    public final void addCollider(Collider collider) {
        this.collider = collider;
        this.collider.setOwner(this);
    }
    
    public final Collider getCollider() {
        return collider;
    }
    
    public void start() {}
    
    public void update() {}
    
    public void onKeyUp (KeyEvent e) {}
    
    public void onKeyDown (KeyEvent e) {}
    
    public void onKeyPressed (KeyEvent e) {}
}
