/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;

/**
 * This imitates a domino 
 * 
 * @param topValue this holds one of the values in a domino
 * @param bottomValue this holds the other value
 * 
 * @author Ilias Kolesidis
 */
public class DominoTile {
    private int topValue;
    private int bottomValue;
/**
 * constructor takes the values in the dominos
 * 
 * @param aTopValue its top value
 * @param aBottomValue its bottom value
 */
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
/**
 *  changeOrientation swaps the values of topValue
 *  and bottomValue
 */
    public void changeOrientation(){
        int temp=topValue;
        topValue=bottomValue;
        bottomValue=temp;
    }
}
