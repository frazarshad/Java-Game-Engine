/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import components.Animation;
import components.AnimationController;
import components.GameObject;
import components.StaticImage;
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
        GameObject background = new Background();
        engine.addGameObject(background);
        // --------------------------------
        
        
        // Player Object
        GameObject obj = new Player();
        engine.addGameObject(obj);
        // ----------------------------------
        
        GameObject box = new Box();
        engine.addGameObject(box);
        
//
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                engine.setUpEngine();
//            }
//        });
        engine.setUpEngine();

    }

}
