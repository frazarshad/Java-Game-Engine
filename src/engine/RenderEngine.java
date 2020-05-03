/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import components.GameObject;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;

/**
 *
 * @author Fraz
 */
public class RenderEngine extends JFrame {
    
    public RenderEngine() {
        setUpEngine();
    }
    
    private void setUpEngine() {
        this.setSize(640, 480);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void paint(Graphics graphics) {
        Graphics2D graphics2d = (Graphics2D)graphics;
//        graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                RenderingHints.VALUE_ANTIALIAS_ON);
//        Font font = new Font("Serif", Font.PLAIN, 24);
//        graphics2d.setFont(font);
//        graphics2d.drawString("ABCD", 70, 70);

        GameObject obj = new GameObject("test.png");
        boolean drawImage = graphics2d.drawImage(obj.getSprite(), 70, 70, this);
    }
}
