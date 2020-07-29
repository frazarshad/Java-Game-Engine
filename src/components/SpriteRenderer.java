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
public interface SpriteRenderer {
    public BufferedImage getSprite(); 
    public void changeAnimation(String animationName);

}

