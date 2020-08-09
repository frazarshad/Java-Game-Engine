/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import components.AudioController;
import components.GameObject;
import components.StaticImage;

/**
 *
 * @author Fraz
 */
public class Background extends GameObject {

    @Override
    public void start() {
        
        this.setSpriteRenderer(
                new StaticImage("background.png")
        );
        this.setLocation(0, 0);
        
    }
    
    

}
