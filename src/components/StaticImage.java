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
public class StaticImage implements SpriteRenderer {

    private BufferedImage sprite = null;

    public StaticImage(String location) {
        try {
            sprite = ImageIO.read(new File(location));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BufferedImage getSprite() {
        return sprite;
    }

    @Override
    public void changeAnimation(String animationName) {
        throw new UnsupportedOperationException("Not supported In Static Image."
                + "use Animation Controller instead.");
    }
    
    
}
