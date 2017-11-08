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
    private ArrayList<DominoTile> board = new ArrayList<>(28); 

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
            return true;
        }else if(!isPlacedInBack){
            //check if reversal is needed
            DominoTile tempTile = board.get(0);
            if(tempTile.getTopValue()!=aTile.getBottomValue()){
                aTile.changeOrientation();
            }
            board.add(0,aTile);
            return true;
            }
        }
        return false;
    }
//    public DominoTile getFront(){
//        for (DominoTile domino: board){
//            if (domino.isFront()){
//                return domino;
//            }
//        }
//        DominoTile itWillNeverReachHere = new DominoTile(-1,-1,false,false);
//        return itWillNeverReachHere;
//    }
//    public DominoTile getBack(){
//        for (DominoTile domino:board){
//            if (domino.isBack()){
//                return domino;
//            }
//        }
//        DominoTile itWillNeverReachHere = new DominoTile(-1,-1,false,false);
//        return itWillNeverReachHere;
//    }
    public void printBoard(){
        //int i=1;
        for (DominoTile aDomino :board){
            System.out.printf(" %d-%d |",aDomino.getTopValue(),aDomino.getBottomValue());
            //i++;
        }
    }
}