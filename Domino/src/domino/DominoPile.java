/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino;
import java.util.ArrayList;
import java.util.Collections;
/**generate a set of dominos and shuffle it
 *
 * @author Ilias Kolesidis
 */
public class DominoPile {
    private int typeOfSet;
    private ArrayList<DominoTile> dominos;
    
    public DominoPile(int set) {
        typeOfSet=set;
        if (typeOfSet==6){
            dominos = new ArrayList<DominoTile>(28);
        }else if(typeOfSet==9){
            dominos = new ArrayList<DominoTile>(55);
        }else{
            typeOfSet=0;
        }
    }
    /**start generation of the pile
     * after generation the pile is shuffled
     * 
     */
    public void generate(){
        if (typeOfSet>0){
            for (int i=0;i<=typeOfSet;i++){
                for (int j=i;j<=typeOfSet;j++){
                    DominoTile aTile = new DominoTile(i,j);
                    dominos.add(aTile);
                }
            }
            Collections.shuffle(dominos);
        }else{
            System.out.printf("\n Can't generate");
        }
    }
    
    
}
