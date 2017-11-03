/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

/**
 *
 * @author Ilias Kolesidis
 */
public class DominoValue {
    private int topValue;
    private int bottomValue;
    private boolean front=false;
    private boolean back=false;

    public DominoValue(int aTopValue, int aBottomValue, boolean aFront,boolean aBack) {
        topValue = aTopValue;
        bottomValue = aBottomValue;
        front= aFront;
        back= aBack;
    }
    public int  getTopValue(){
        return topValue;
    }
    public int getBottomValue(){
        return bottomValue;
    }
    public boolean isFront(){
        return front;
    }
    public boolean isBack(){
        return back;
    }
}
