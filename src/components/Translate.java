/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;

import util.Pair;

/**
 *
 * @author Fraz
 */
public class Translate {
    
    private Pair position;
    private Pair prevPosition;
    
    public Translate(int x, int y) {
        position = new Pair(x, y);
        prevPosition = new Pair (x, y);
    }
    
    public void setLocation(int x, int y) {
        prevPosition.setPair(position);
        position.setPair(x, y);
    }
    
    public Pair getPosition() {
        return position;
    }
    
    public void setPreviousPosition() {
        position.setPair(prevPosition);
    }
    
}
