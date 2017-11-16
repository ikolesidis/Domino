/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.Clii;
import java.util.Scanner;
/**
 *
 * @author Ilias Kolesidis
 */
public class CliHelp {
    public int language;        // 0 for greek 1 for english
    //private Scanner scan = new Scanner(System.in);
    public CliHelp() {
        
    }
    public void help(int aLocation){
        if (aLocation==0){
            helpStartMenu();
        }else if (aLocation==1){
            helpOptions();
        }else if(aLocation==2){
            helpSelectGameType();
        }else if(aLocation==3){
            helpSelectNumberOfPlayers();
        }else{
            //call 
        }
    }
    private void helpStartMenu(){
        if (language==0){
            System.out.printf("\n  Βάλτε τον αριθμό στη παρένθεση για να κάνετε την επιλογή σας");
            System.out.printf("\n  Στο (1) Αρχίζετε ένα παιχνίδι ντόμινο");
            System.out.printf("\n  Στο (2) Μπορείτε να αλλάξετε τη γλώσσα");
            System.out.printf("\n  Στο (3) Βγαίνετε από την εφαρμογή\n");
        }else if(language==1){
            System.out.printf("\n  You enter the number in the parenthesis to pick your choice");
            System.out.printf("\n  In (1) you start a game of domino");
            System.out.printf("\n  In (2) you can change the language");
            System.out.printf("\n  In (3) you exit the application\n");
        }
    }
    private void helpOptions(){
        if (language==0){
            //greek
        }else if(language==1){
            //english
        }
    }
    private void helpSelectGameType(){
        if (language==0){
            //greek
        }else if(language==1){
            //english
        }
    }
    private void helpSelectNumberOfPlayers(){
        if (language==0){
            System.out.printf("\n  Εδώ επιλέγετε τον αριθμό των παιχτών");
            System.out.printf("\n   με ένα να ειστε εσείς και οι υπόλιποι μποτάκια");
            System.out.printf("\n   εισάγωντας '5' πιγένεται πισω στην επιλογή παιχνιδιού");
        }else if(language==1){
            System.out.printf("\n  Here you can select how many players there will be");
            System.out.printf("\n   with one being you and the rest will be bots");
            System.out.printf("\n   entering '5' will take you back to the select game screen");
        }
    }
    
}
