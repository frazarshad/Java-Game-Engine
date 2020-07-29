/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.image.BufferedImage;
import java.util.Dictionary;
import java.util.HashMap;

/**
 *
 * @author Fraz
 */
public final class AnimationController implements SpriteRenderer{
    
    private Animation currentAnimation = null;
    private HashMap<String, Animation> animations;

    public AnimationController() {
        animations = new HashMap<>();
    }
    
    public void addAnimation(String name, Animation animation) {
        if (currentAnimation == null) {
            currentAnimation = animation;
        }
        animations.put(name, animation);
    }
    
    @Override
    public BufferedImage getSprite() {
        if (currentAnimation != null) {
            return currentAnimation.getSprite();
        } else {
            return null;
        }
    }

    @Override
    public void changeAnimation(String animationName) {
        if (animations.containsKey(animationName)) {
            currentAnimation = animations.get(animationName); 
        }
    }
    
    
    
}
