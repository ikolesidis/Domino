/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.players;

import domino.DominoTile;

/**
 *
 * @author Ilias Kolesidis
 */
public class Person {
    private DominoTile[] hand;
    private int sizeOfHand;
    private int tilesInHand;

    public Person(int numberOfDominos) {
        tilesInHand=0;
        sizeOfHand = numberOfDominos;
        hand = new DominoTile[sizeOfHand];
    }

    public boolean takeFromPile(DominoTile aDomino){
        if (tilesInHand<sizeOfHand){
            hand[tilesInHand]=aDomino;
            tilesInHand++;
            return true;
        }
        return false;
    }
    
    public boolean removeFromHand(int pos){
        if (hand[pos]!=null){
            hand[pos]=null;
            fixHand(pos);
            return true;
        }
        return false;
    }
    
    private void fixHand(int pos){
        while(pos<sizeOfHand&&hand[pos+1]!=null){
            hand[pos]=hand[pos+1];
            hand[pos+1]=null;
            pos++;
        }
    }
    
    public DominoTile getTile(int pos){      
        return hand[pos];
    }
}
