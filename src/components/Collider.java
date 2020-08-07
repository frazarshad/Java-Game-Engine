/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import util.Pair;

/**
 *
 * @author Fraz
 */
public class Collider {
    
    private GameObject owner;
    private Pair offset;
    private Pair dimensions;
    private boolean colliding = false;
    private boolean static_ = false;
    
    public Collider () {
        offset = new Pair(0, 0);
        dimensions = new Pair(0, 0);
    }
    
    public Collider (int length, int width) {
        offset = new Pair(0, 0);
        dimensions = new Pair(length, width);
    }
    
    public void setOwner (GameObject owner) {
        this.owner = owner;
    }
    
    public Collider (int length, int width, int offsetX, int offsetY) {
        offset = new Pair(offsetX, offsetY);
        dimensions = new Pair(length, width);
    }
    
    public final int getOffsetX() {
        return offset.getFirst();
    }

    public final int getOffsetY() {
        return offset.getSecond();
    }
    
    public final int getAbsoluteX() {
        return offset.getFirst() + owner.getX();
    }
    
    public final int getAbsoluteY() {
        return offset.getSecond() + owner.getY();
    }
    
    public final int getWidth() {
        return dimensions.getFirst();
    }
    
    public final int getHeight() {
        return dimensions.getSecond();
    }
    
    public final void setStatic(boolean value) {
        static_ = value;
    }
    
    public final boolean isStatic() {
        return static_;
    }
    
    public final boolean checkCollision(Collider targ) {
        if (
                (
                    this.getAbsoluteX() + this.getWidth() >= targ.getAbsoluteX() &&
                    targ.getAbsoluteX() + targ.getWidth() >= this.getAbsoluteX() 
                )
                &&
                (
                    this.getAbsoluteY() + this.getHeight() >= targ.getAbsoluteY() &&
                    targ.getAbsoluteY() + targ.getHeight() >= this.getAbsoluteY() 
                )
           )
            colliding = true;
        else
            colliding = false;
        
        return colliding;
    }
    
    public final boolean isColliding() {
        return colliding;
    }
}
