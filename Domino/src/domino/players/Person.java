/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.players;

import domino.DominoTile;

/**
 * this class imitates a domino player
 * 
 * @param hand this stores the dominos that tha player 'picks up'
 * @param sizeofHand this stires how many dominos the player can have in his hand
 * @param tileesInHand this stores the current number of dominos the player has
 *
 * @author Ilias Kolesidis
 */
public class Person {
    private DominoTile[] hand;
    private int sizeOfHand;
    private int tilesInHand;
/**
 * The initialiser takes in the number of the dominos the player can hold
 * and creates an array
 * 
 * @param numberOfDominos number of dominos the player can hold
 */
    public Person(int numberOfDominos) {
        tilesInHand=0;
        sizeOfHand = numberOfDominos;
        hand = new DominoTile[sizeOfHand];
    }
/**
 * this takes in a domino and places it in the players hand
 * 
 * @param aDomino DominoTile object that the player puts in his hand
 * @return returns true if successfully took a domino
 */
    public boolean takeFromPile(DominoTile aDomino){
        if (tilesInHand<sizeOfHand){
            hand[tilesInHand]=aDomino;
            tilesInHand++;
            return true;
        }
        return false;
    }
/**
 * this takes a domino from the players hand and removes it
 * 
 * @param pos which tile to remove
 * @return return true if removed successfully
 */    
    public boolean removeFromHand(int pos){
        if (hand[pos]!=null){
            hand[pos]=null;
            fixHand(pos);
            return true;
        }
        return false;
    }
/**when removing a tile from the hand its position is null and 
 * this may lead to gaps, this fixes the gaps shifting the dominos until there
 * is no gap
 * 
 * @param pos the position which is null
 */    
    private void fixHand(int pos){
        while(pos<sizeOfHand&&hand[pos+1]!=null){
            hand[pos]=hand[pos+1];
            hand[pos+1]=null;
            pos++;
        }
    }
/**
 * returns a tile 
 * 
 * @param pos where the tile is in the hand
 * @return return the tile if its there else return a tile with (-1,-1) values
 */    
    public DominoTile getTile(int pos){ 
        if (hand[pos]!=null){
            return hand[pos];
        }else{
            DominoTile aTile = new DominoTile(-1,-1);
            return aTile;
        }
    }
}
