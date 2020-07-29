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
    
    KeyEvent typed;
    KeyEvent pressed = null;
    
    private KeyReader() {}
    
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
    public void keyTyped(KeyEvent e) {
  //      System.out.println("PRESS");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed = e;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed = null;
    }
    
    
    public KeyEvent currentPressed() {
        return pressed;
    }
    
    public int currentPressedKey() {
        if (pressed != null) {
            return pressed.getKeyCode();
        } else {
            return -1;
        }
        
    }
    
}
