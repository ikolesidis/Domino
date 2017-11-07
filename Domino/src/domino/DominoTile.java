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
public class DominoTile {
    private int topValue;
    private int bottomValue;

    public DominoTile(int aTopValue, int aBottomValue) {
        topValue = aTopValue;
        bottomValue = aBottomValue;
    }
    public int  getTopValue(){
        return topValue;
    }
    public int getBottomValue(){
        return bottomValue;
    }
    public void changeOrientation(){
        int temp=topValue;
        topValue=bottomValue;
        bottomValue=temp;
    }
}
