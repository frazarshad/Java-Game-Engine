/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import components.GameObject;
import components.KeyReader;
import java.awt.event.KeyEvent;

/**
 *
 * @author Fraz
 */
public class Player extends GameObject {

    private KeyReader reader;

    @Override
    public void start() {
        reader = getKeyReaderFromEngine();
    }
    
    @Override
    public void update() {
        switch (reader.currentPressedKey()) {
            case KeyEvent.VK_H:
                spriteRenderer.changeAnimation("second");
                break;
            case KeyEvent.VK_G:
                spriteRenderer.changeAnimation("main");
                break;
        }
    }
    
}
