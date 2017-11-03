/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
//import domino.DominoValue;
import java.util.ArrayList;
/**
 *
 * @author Ilias Kolesidis
 */
public class DominoBoard {
    private ArrayList<DominoValue> board = new ArrayList<>(28); 

    public boolean addDomino(int topValue,int bottomValue, boolean aFront, boolean aBack){
        DominoValue domino = new DominoValue(topValue, bottomValue,aFront,aBack);
        if (board.isEmpty()){
            board.add(domino);
            return true;
        }else{
        if (aFront){
            for (DominoValue aDomino : board){
                if (aDomino.isFront()){
                    int top = aDomino.getTopValue();
                    int bottom = aDomino.getBottomValue();
                    DominoValue newDomino = new DominoValue(top,bottom,false,aDomino.isBack());
                    board.set(board.indexOf(aDomino),newDomino);
                }
            }
            board.add(domino);
            return true;
        }else if(aBack){
            for (DominoValue aDomino : board){
                if(aDomino.isBack()){
                    int top=aDomino.getTopValue();
                    int bottom = aDomino.getBottomValue();
                    DominoValue newDomino = new DominoValue(top,bottom,aDomino.isFront(),false);
                    board.set(board.indexOf(aDomino),newDomino);
                    int pos = board.indexOf(aDomino);
                    pos++;              //dont change this
                    board.add(pos,domino);
                    return true;
                }
            }
        }
        }
        return false;
    }
    public DominoValue getFront(){
        for (DominoValue domino: board){
            if (domino.isFront()){
                return domino;
            }
        }
        DominoValue itWillNeverReachHere = new DominoValue(-1,-1,false,false);
        return itWillNeverReachHere;
    }
    public DominoValue getBack(){
        for (DominoValue domino:board){
            if (domino.isBack()){
                return domino;
            }
        }
        DominoValue itWillNeverReachHere = new DominoValue(-1,-1,false,false);
        return itWillNeverReachHere;
    }
    public void printBoard(){
        int i=1;
        for (DominoValue aDomino :board){
            System.out.printf("\n %d: top =%d, bottom =%d, front =%b, back =%b",i,aDomino.getTopValue(),aDomino.getBottomValue(),aDomino.isFront(),aDomino.isBack());
            i++;
        }
    }
}