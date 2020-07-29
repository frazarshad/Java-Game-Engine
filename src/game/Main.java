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
        GameObject background = new GameObject();
        background.setSpriteRenderer(
                new StaticImage("background.png")
        );
        background.setLocation(0, 0);
        engine.addGameObject(background);
        // --------------------------------
        
        
        // Player Object
        GameObject obj = new Player();
        AnimationController controller = new AnimationController();
        controller.addAnimation(
                "main",
                new Animation(
                        "test1.png",
                        "test2.png",
                        "test3.png"
                )
        );
        controller.addAnimation(
                "second",
                new Animation(
                        4,
                        "test1.png",
                        "test2.png",
                        "test3.png"
                )
        );
        obj.setSpriteRenderer(controller);
        obj.setLocation(400, 300);
        engine.addGameObject(obj);
        // ----------------------------------
        
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
