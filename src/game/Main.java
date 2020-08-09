/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import components.GameObject;
import engine.RenderEngine;

/**
 *
 * @author Fraz
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RenderEngine engine = RenderEngine.createEngine();
        
        // Background
//        GameObject background = new Background();
//        engine.addGameObject(background);
        // --------------------------------
        
        // Adding BorderBlocks
        GameObject[] blocks = {
            new VerticalBlock(0, 0),
            new VerticalBlock(0, 400),
            new HorizontalBlock(0, 0),
            new HorizontalBlock(400, 0),
            new VerticalBlock(580, 0),
            new VerticalBlock(580, 400),
            new HorizontalBlock(0, 580),
            new HorizontalBlock(400, 580),
            new VerticalBlock(50, 50),
            new VerticalBlock(50, 150),
            new VerticalBlock(100, 50),
            new VerticalBlock(100, 150),
            new VerticalBlock(150, 50),
            new VerticalBlock(150, 150),
            new VerticalBlock(200, 50),
            new VerticalBlock(200, 150),
            new VerticalBlock(250, 50),
            new VerticalBlock(250, 150),
            new VerticalBlock(300, 50),
            new VerticalBlock(300, 150),
            new VerticalBlock(350, 50),
            new VerticalBlock(350, 150),
            new VerticalBlock(400, 50),
            new VerticalBlock(400, 150),
            new VerticalBlock(450, 50),
            new VerticalBlock(450, 150),
            new VerticalBlock(500, 50),
            new VerticalBlock(500, 150),
            new VerticalBlock(550, 50),
            new VerticalBlock(550, 150)
        };
    
        for (GameObject g : blocks)
            engine.addGameObject(g);
        
        
        GameObject[] stars = {
            new Star(24, 60),
            new Star(24, 90),
            new Star(24, 120),
            new Star(24, 150),
            new Star(24, 180),
            new Star(24, 210),
            new Star(24, 240),
            new Star(24, 270),
            new Star(24, 300),
            new Star(24, 330),
            
            new Star(74, 60),
            new Star(74, 90),
            new Star(74, 120),
            new Star(74, 150),
            new Star(74, 180),
            new Star(74, 210),
            new Star(74, 240),
            new Star(74, 270),
            new Star(74, 300),
            new Star(74, 330),
            
            new Star(124, 60),
            new Star(124, 90),
            new Star(124, 120),
            new Star(124, 150),
            new Star(124, 180),
            new Star(124, 210),
            new Star(124, 240),
            new Star(124, 270),
            new Star(124, 300),
            new Star(124, 330),
        };
        
        for (GameObject g : stars)
            engine.addGameObject(g);
        

        GameObject pacman = new Pacman();
        engine.addGameObject(pacman);
        
        engine.setSize(600, 600);
        engine.setUpEngine();

    }

}
