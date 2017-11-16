/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
//import domino.DominoValue;
import java.util.ArrayList;
/**
 * this is a board where dominos are placed
 * while creating it i visualised a stack with 
 * the top as 'front' and bottom as 'back'
 *
 * @param board here is where the dominos will be saved
 * @param undoTile this is a stack that holds placed domino tiles
 * @param undoTileWasPlacedInBack paired with undoTile holds the position of the dominos
 * @author Ilias Kolesidis
 */
public class DominoBoard {
    private ArrayList<DominoTile> board;
    private ArrayList<DominoTile> undoTile = new ArrayList<DominoTile>(10);
    private ArrayList<Integer> undoTileWasPlacedOnBack = new ArrayList<Integer>(10);
    private int undoStackSize = 10;
    
/**
 * the constructor takes an int as the size of the board with
 * 28 for a 6 set and 55 for a 9 set
 * 
 * @param size 
 */
    public DominoBoard(int size) {
        if (size>0){
            board = new ArrayList<DominoTile>(size);
        }
    }
/**
 * add a domino to the board while checking the orientation so that 
 * it is placed correctly
 * 
 * @param aTile the tile that will be placed in the board
 * @param isPlacedInBack checks on what end it will be placed
 * @return returns true if it was placed successfully
 */
    public boolean addDomino(DominoTile aTile,boolean isPlacedInBack){
        if (board.isEmpty()){
            board.add(aTile);
            return true;
        }else{
        if (isPlacedInBack){
            int pos = board.size()-1;
            DominoTile tempTile = board.get(pos);
            if (tempTile.getBottomValue()!=aTile.getTopValue()){
                aTile.changeOrientation();
            }
            board.add(aTile);
            addToUndo(aTile);
            return true;
        }else if(!isPlacedInBack){
            //check if reversal is needed
            DominoTile tempTile = board.get(0);
            if(tempTile.getTopValue()!=aTile.getBottomValue()){
                aTile.changeOrientation();
            }
            board.add(0,aTile);
            addToUndo(aTile);
            return true;
            }
        }
        return false;
    }
    
/**prints the whole board
 * 
 */
    public void printBoard(){
        //int i=1;
        for (DominoTile aDomino :board){
            System.out.printf(" %d-%d |",aDomino.getTopValue(),aDomino.getBottomValue());
            //i++;
        }
    }
/**
 * this method removes the most recent tile that was added to the board
 * 
 * @return returns the tile it removed from the board and if undoTile is empty return a tile with (-1,-1) values
 */
    public DominoTile undo(){
        if (!undoTile.isEmpty()){
                DominoTile aTile = undoTile.get(undoTile.size()-1);
                board.remove(aTile);
                undoTile.remove(aTile);
                return aTile;
        }else{
            DominoTile aTile = new DominoTile(-1, -1);
            return aTile;
        }
    }
/**
 * every time a tile is added to the board this method is called
 * it places the tile that was just added to undoTile so that
 * it can be removed later
 * 
 * @param aTile tile to be added
 */
    private void addToUndo(DominoTile aTile){
        if (undoTile.size()!=undoStackSize){
            undoTile.add(aTile);
        }else{
            undoStackSize= undoStackSize+10;
            undoTile.ensureCapacity(undoStackSize);
            addToUndo(aTile);
        }
    }
    
    
}