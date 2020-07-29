/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Fraz
 */
public final class Animation {

    private BufferedImage[] sprites;
    
    private int speed;
    private long lastTime;
    private long newTime;
    private long deltaTime;

    public Animation(String... spriteLocations) {
        speed = 500;
        lastTime =  System.currentTimeMillis();
        this.setAnimationSprites(spriteLocations);
    }
    
    public Animation(int speed, String... spriteLocations) {
        this.speed = speed;
        lastTime =  System.currentTimeMillis();
        this.setAnimationSprites(spriteLocations);    
    }
    
    public void setSpeed(int time) {
        speed = time;
    }

    public void setAnimationSprites(String... spriteLocations) {
        sprites = new BufferedImage[spriteLocations.length];
        for (int i = 0; i < spriteLocations.length; i++) {
            try {
                sprites[i] = ImageIO.read(new File(spriteLocations[i]));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public BufferedImage getSprite() {
        newTime = System.currentTimeMillis();
        deltaTime = newTime - lastTime;
        int index = (int)(deltaTime / speed) % sprites.length;
        return sprites[index];
    }

}
