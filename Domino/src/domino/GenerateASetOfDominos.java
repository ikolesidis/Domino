/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
import java.util.ArrayList;
/**
 *
 * @author Ilias Kolesidis
 */
public class GenerateASetOfDominos {
    private int typeOfSet;
    private ArrayList<DominoTile> dominos;
    
    public GenerateASetOfDominos(int set) {
        if (set==6){
            typeOfSet=set;
            dominos = new ArrayList<DominoTile>(28);
        }else if(set==9){
            typeOfSet=set;
            dominos = new ArrayList<DominoTile>(55);
        }else{
            typeOfSet=0;
        }
    }
    public void generate(){
        for (int i=0;i<7;i++){
            for (int j=i;j<7;j++){
                //DominoTile aTile = new DominoTile(i, j, false, false);
            }
        }
    }
    
    
}
