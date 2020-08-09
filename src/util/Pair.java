/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Fraz
 */
public class Pair {

    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public final int getFirst() {
        return first;
    }

    public final int getSecond() {
        return second;
    }

    public final void setFirst(int first) {
        this.first = first;
    }

    public final void setSecond(int second) {
        this.second = second;
    }

    public final void setPair(int first, int second) {
        this.second = second;
        this.first = first;
    }
    
    public final void setPair(Pair pair) {
        this.second = pair.second;
        this.first = pair.first;
    }
}
