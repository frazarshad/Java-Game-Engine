/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Fraz
 */
public class AnimationController implements SpriteRenderer{
    
    private Animation currentAnimation = null;
    private ArrayList animations;

    public AnimationController() {
        animations = new ArrayList();
    }
    
    public void addAnimation(Animation animation) {
        if (currentAnimation == null) {
            currentAnimation = animation;
        }
        animations.add(animation);
    }
    
    @Override
    public BufferedImage getSprite() {
        return currentAnimation.getSprite();
    }
    
    
    
}
