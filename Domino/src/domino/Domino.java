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
public class Domino {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DominoBoard board = new DominoBoard();
        board.addDomino(0, 0, true, true);
        board.printBoard();
        board.addDomino(5, 0, true,false);
        board.printBoard();
        board.addDomino(6,5,true,false);
        board.printBoard();
        board.addDomino(0, 3, false, true);
        board.printBoard();
    }
    
}
