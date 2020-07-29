/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import engine.RenderEngine;
import java.awt.image.BufferedImage;

/**
 *
 * @author Fraz
 */
public class GameObject {
    
    private RenderEngine owner;
    protected SpriteRenderer spriteRenderer = null;
    private int x = 0;
    private int y = 0;
    
    public final void setEngine(RenderEngine engine) {
        owner = engine;
    }
    
    public final void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public final int getX() {
        return x;
    }
    
    public final int getY() {
        return y;
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
    
    public final KeyReader getKeyReaderFromEngine() {
        return owner.getKeyReader();
    }
    
    public void start() {}
    
    public void update() {}
    
}
