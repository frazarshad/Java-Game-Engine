/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Fraz
 */
public class KeyReader implements KeyListener{

    private static KeyReader INSTANCE = null;
    
    boolean prevPressed = false;
    boolean currentPressed = false;
    KeyEvent pressed = null;
    
    // Single frame key down
    boolean keyPressedDown = false;
    boolean keyPressable = true;
    
    
    public static KeyReader createKeyReader() {
        if (INSTANCE == null) {
            return new KeyReader();
        } else {
            return null;
        }
    }
    
    protected void finalize() {
        INSTANCE = null;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        pressed = e;
     
        if (keyPressable) {
            keyPressedDown = true;
            keyPressable = false;
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        keyPressable = true;
        pressed = null;
    }
    
    public void setPressOff() {
        keyPressedDown = false;
    }
    
    public boolean isPressed() {
        if (pressed == null) {
            return false;
        } else {
            return true;
        }
    }
    
    public boolean isPressedOnThisFrame() {
        return keyPressedDown;
    }
    
//    public boolean isReleasedOnThisFrame() {
//        return keyPressedDown;
//    }
    
    public KeyEvent currentPressedKey() {
        return pressed;
    }

}
