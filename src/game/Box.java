/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import components.Collider;
import components.GameObject;

/**
 *
 * @author Fraz
 */
public class Box extends GameObject {

    @Override
    public void start() {
        this.addCollider(new Collider(40, 40));
    }
    
}
