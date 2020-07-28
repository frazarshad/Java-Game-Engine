/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import components.GameObject;
import javax.swing.SwingUtilities;

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
        background.setSprite("background.png");
        background.setLocation(0, 0);
        
        GameObject obj = new GameObject();
        obj.setSprite("test.png");
        obj.setLocation(600, 400);
        
        engine.addGameObject(background);
        engine.addGameObject(obj);
        
        SwingUtilities.invokeLater( new Runnable() {
         @Override
         public void run() {
            engine.setUpEngine();
         }
      });
    }
    
}
