/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package debugtools;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Fraz
 */
public class FrameRate {
    
    private String frameRate;
    private long lastTime;
    private long delta;
    private int frameCount;
    
    public FrameRate() 
    {
        lastTime = System.currentTimeMillis();
        frameRate = "FPS 0";
    }
    
    private void calculate() {
        long current = System.currentTimeMillis();
        delta += current - lastTime;
        lastTime = current;
        frameCount++;
        if( delta > 1000 ) {
            delta -= 1000;
            frameRate = String.format( "FPS %s", frameCount );
            frameCount = 0;
        }
    }
    public String getFrameRate() {
        return frameRate;
    }
    
    public void drawFrameRate(Graphics g) {
        calculate();
        
        g.setColor( Color.GREEN );
        g.drawString(frameRate, 30, 30);
    }
}
