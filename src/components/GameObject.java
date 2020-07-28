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
    
    private Sprite sprite;
    private int x;
    private int y;
    
    public GameObject() {
        sprite = new Sprite();
        x = y = 25;
    }
    
    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public BufferedImage getSprite() {
        return sprite.getSprite();
    }
    
    public void setSprite(String spriteLocation) {
        sprite.setSprite(spriteLocation);
    }
}
