/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import engine.RenderEngine;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Fraz
 */
public class GameObject {
    
    private SpriteRenderer spriteRenderer = null;
    private Collider collider = null;
    private AudioController audioController = null;
    private Translate translate;
    private RenderEngine owner;
    
    
    public GameObject () {
        translate = new Translate(0, 0);
    }
    
    public GameObject (int x, int y) {
        translate = new Translate(x, y);
    }
    
    public void setOwner(RenderEngine e) {
        this.owner = e;
    } 
    
    public RenderEngine getRenderEngine () {
        return owner;
    }
    
    public final void move(int x, int y) {
        if (!(collider != null && collider.isColliding()))
            translate.getPosition().setPair(x, y);
    }
    
    public final int getX() {
        return translate.getPosition().getFirst();
    }
    
    public final int getY() {
        return translate.getPosition().getSecond();
    }

    public void setLocation (int x, int y) {
        translate.setLocation(x, y);
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

    public SpriteRenderer getSpriteRenderer() {
        return spriteRenderer;
    }
    
    public final void addCollider(Collider collider) {
        this.collider = collider;
        this.collider.setOwner(this);
    }
    
    public final void addAudioController(AudioController audioController) {
        this.audioController = audioController;
    }

    public AudioController getAudioController() {
        return audioController;
    }
    
    public final Translate getTranslate() {
        return translate;
    }
    
    public final Collider getCollider() {
        return collider;
    }
    
    public void delete() {
        owner.addToDeleteList(this);
    }
    
    public void start() {}
    
    public void update() {}
    
    public void onKeyUp (KeyEvent e) {}
    
    public void onKeyDown (KeyEvent e) {}
    
    public void onKeyPressed (KeyEvent e) {}
    
    public void onCollision (GameObject collision) {}
}
