/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.image.BufferedImage;

/**
 *
 * @author Fraz
 */
public class GameObject {
    private SpriteRenderer spriteRenderer = null;
    private int x = 0;
    private int y = 0;
        
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
        return spriteRenderer.getSprite();
    } 
    
    public final void setSpriteRenderer(SpriteRenderer spriteRenderer) {
        this.spriteRenderer = spriteRenderer;
    }
    
    public void update() {}
    
}
