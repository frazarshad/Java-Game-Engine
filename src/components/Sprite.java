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
public class Sprite {
    private BufferedImage sprite;
//    
//    public Sprite(String spriteLocation) {
//        setSprite(spriteLocation);
//    }
    
    public BufferedImage getSprite() {
        return sprite;
    } 
    
    public void setSprite(String spriteLocation) {
        try {
            sprite = ImageIO.read(new File(spriteLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
