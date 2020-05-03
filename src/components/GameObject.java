/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import com.sun.javafx.runtime.SystemProperties;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Fraz
 */
public class GameObject {
    private BufferedImage sprite;
    
    public GameObject(String spriteLocation) {
        try {
            sprite = ImageIO.read(new File(spriteLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public BufferedImage getSprite() {
        return sprite;
    }
}
