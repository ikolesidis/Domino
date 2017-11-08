/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.Gui;
import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author Ilias Kolesidis
 */
public class CmdUi {
    private Scanner scan=  new Scanner(System.in);
    private String nextCommand;
    private Locale country;
    private int greekOrEnglish; //greek is 0 english is 1, 2 is exit
    
    public void startCmd(){
        scan.useDelimiter("\n");
        country= Locale.getDefault();
        if(country.getCountry().equals("GR")){
            greekOrEnglish=0;
        }else{
            greekOrEnglish=1;
        }
        while(greekOrEnglish!=2){
            if(greekOrEnglish==0){
                startWithGreek();
            }else if(greekOrEnglish==1){
                startWithEnglish();
            }
        }
    }
    
    private void startWithGreek(){
        int key=100;
        while(key!=0){
            try{
                System.out.printf("\nΜπρορείτε να γράψτε 'βοήθεια' σε κάθε στηγμή.");
                System.out.printf("\n(1) - Παίξτε ένα παιχνίδι");
                System.out.printf("\n(2) - Επιλογές");
                System.out.printf("\n(3) - Έξοδος\n");
                nextCommand=scan.next();
                scan.nextLine();
                key=Integer.parseInt(nextCommand);
            }catch(NumberFormatException e){
                
            }
            System.out.printf("\n%d",key);
            if (nextCommand.equalsIgnoreCase("βοηθεια")||nextCommand.equalsIgnoreCase("βοηθεια")){
                System.out.printf("\n  Βάλτε τον αριθμό στη παρένθεση για να κάνετε την επιλογή σας");
                System.out.printf("\n  Στο (1) Αρχίζετε ένα παιχνίδι ντόμινο");
                System.out.printf("\n  Στο (2) Μπορείτε να αλλάξετε τη γλώσσα");
                System.out.printf("\n  Στο (3) Βγαίνετε από την εφαρμογή\n");
            }else if(key==1){
                startGamesInGreek();
            }else if(key==2){
                greekOrEnglish=0;
                key=settingsInGreek();
                while(key!=3){
                    if(key==2){
                        key=settingsInGreek();
                        greekOrEnglish=0;
                    }else if(key==1){
                        key=settingsInEnglish();
                        greekOrEnglish=1;
                    }
                }
                if (greekOrEnglish==1){
                    key=0;
                }
            }else if(key==3){
                key=0;
                greekOrEnglish=2;
            }else{
                System.out.printf("\n  Παρακαλώ δώστε μία σωστή επιλογή");
            }
        }
    }
    
    private void startWithEnglish(){
        int key=100;
        while(key!=0){
            try{
                System.out.printf("\nYou can type 'help' at any point.");
                System.out.printf("\n(1) - Play a game");
                System.out.printf("\n(2) - Settings");
                System.out.printf("\n(3) - Exit\n");
                nextCommand=scan.next();
                scan.nextLine();
                key=Integer.parseInt(nextCommand);
            }catch(NumberFormatException e){
                }
            if (nextCommand.equalsIgnoreCase("help")){
                System.out.printf("\n  You enter the number in the parenthesis to pick your choice");
                System.out.printf("\n  In (1) you start a game of domino");
                System.out.printf("\n  In (2) you can change the language");
                System.out.printf("\n  In (3) you exit the application\n");
            }else if(key==1){
                startGamesInEnglish();
            }else if(key==2){
                greekOrEnglish=1;
                key=settingsInEnglish();
                while(key!=3){
                    if(key==2){
                        key=settingsInGreek();
                        greekOrEnglish=0;
                    }else if(key==1){
                        key=settingsInEnglish();
                        greekOrEnglish=1;
                    }
                }
                if (greekOrEnglish==0){
                    key=0;
                }
            }else if(key==3){
                System.out.printf("\nAre you sure you want to exit(y/n)\n");
                nextCommand=scan.next();
                if(nextCommand.equals("y")){
                    key=0;
                    greekOrEnglish=2;
                }else{
                    key=100;
                }
            }else{
                System.out.printf("\n  Input was incorrect, please try again");
            }
        }
    }
    
    private int settingsInEnglish(){
        int key=100;
        while (key!=0){
            System.out.printf("\nChose language");
            System.out.printf("\n(1) - English");
            System.out.printf("\n(2) - Ελληνικά");
            System.out.printf("\n(3) - Go Back\n");
            nextCommand=scan.next();
            key=Integer.parseInt(nextCommand);
            if(key==1){
                System.out.printf("\nLanguage is already English\n");
            }else if(key==2){
                System.out.printf("\nΗ γλώσσα άλλαξε\n");
                return key;
            }else if(key==3){
                return key;
            }else{
                System.out.printf("\n  Input was incorrect, please try again");
            }
        }
        return key;
    }
    
    private int settingsInGreek(){
        int key=100;
        while (key!=0){
            System.out.printf("\nΔιαλέξτε γλώσσα");
            System.out.printf("\n(1) - English");
            System.out.printf("\n(2) - Ελληνικά");
            System.out.printf("\n(3) - Πίσω\n");
            nextCommand=scan.next();
            key=Integer.parseInt(nextCommand);
            if(key==1){
                System.out.printf("\nLanguage is now English\n");
                return key;
            }else if(key==2){
                System.out.printf("\nΗ γλώσσα είναι ίδη Ελληνικά\n");
            }else if(key==3){
                return key;
            }else{
                System.out.printf("\n  Παρακαλώ δώστε μία σωστή επιλογή");
            }
        }
        return key;        
    }
    private void startGamesInGreek(){
        int n=100;
        while (n!=0){
            try{
                System.out.printf("\nΕπιλέξτε τύπο παιχνιδιού");
                System.out.printf("\n(1) - Σόλο 1");
                System.out.printf("\n(2) - Ουγγρικό ντομινό (2-4) παίχτες");
                System.out.printf("\n(3) - 'Ολα 7 (2-4) παίχτες");
                System.out.printf("\n(4) - Πίσω\n");
                nextCommand=scan.next();
                scan.nextLine();
                n=Integer.parseInt(nextCommand);
            }catch(NumberFormatException e){
                
            }
            if(nextCommand.equalsIgnoreCase("βοήθεια")||nextCommand.equalsIgnoreCase("βοηθεια")){
                System.out.println("help here");
            }else if(n==1){
                //start solo1()
                n=0;
            }else if(n==2){
                n=howManyPlayersGreek();
                if(n!=5){
                    //start hungarian(n)
                    n=0;
                }else{
                    n=100;
                }
            }else if(n==3){
                n=howManyPlayersGreek();
                if(n!=5){
                    //start all7(n)
                    n=0;
                }else{
                    n=100;
                }
            }else if(n==4){
                n=0;
            }else {
                System.out.printf("\n  Παρακαλώ δώστε μία σωστή επιλογή");
            }
        }
        
    }
    private void startGamesInEnglish(){
        int n=100;
        while (n!=0){
            try{
                System.out.printf("\nChose game mode");
                System.out.printf("\n(1) - Solo 1");
                System.out.printf("\n(2) - Hungarian domino (2-4) players");
                System.out.printf("\n(3) - All 7 (2-4) players");
                System.out.printf("\n(4) - Go back\n");
                nextCommand=scan.next();
                scan.nextLine();
                n=Integer.parseInt(nextCommand);
            }catch(NumberFormatException e){
                
            }
            if(nextCommand.equalsIgnoreCase("help")){
                System.out.println("help here");
            }else if(n==1){
                // start solo1()
                n=0;
            }else if(n==2){
                n=howManyPlayersEnglish();
                if (n!=5){
                    //start hungarianGame(n)
                    n=0;
                }else{
                    n=100;
                }
            }else if(n==3){
                n=howManyPlayersEnglish();
                if(n!=5){
                    //start all7(n)
                    n=0;
                }else{
                    n=100;
                }
            }else if(n==4){
                n=0;
            }else {
                System.out.printf("\n  Input was incorrect, please try again");
            }
        }
    }
    private int howManyPlayersEnglish(){
        int n=100;
        while (n!=0){
            try{
                System.out.printf("\nSelect the number of players 2-4");
                System.out.printf("\n(5) - Go back\n");
                nextCommand=scan.next();
                scan.nextLine();
                n=Integer.parseInt(nextCommand);
            }catch(NumberFormatException e){
            }
            if(nextCommand.equalsIgnoreCase("help")){
                System.out.printf("\n  Here you can select how many players there will be");
                System.out.printf("\n   with one being you and the rest will be bots");
                System.out.printf("\n   entering '5' will take you back to the select game screen");
                n=100;
            }else if(n==2){
                return n;
            }else if(n==3){
                return n;
            }else if(n==4){
                return n;
            }else if(n==5){
                return n;
            }else{
                n=100;
                System.out.printf("\n  Input was incorrect please try again");
            }
        }
        return n;
    }
    private int howManyPlayersGreek(){
        int n=100;
        while (n!=0){
            try{
                System.out.printf("\nΕπιλέξτε τον αριθμό των παιχτόν 2-4");
                System.out.printf("\n(5) - Πίσω\n");
                nextCommand=scan.next();
                scan.nextLine();
                n=Integer.parseInt(nextCommand);
            }catch(NumberFormatException e){
            }
            if(nextCommand.equalsIgnoreCase("βοήθεια")||nextCommand.equalsIgnoreCase("βοηθεια")){
                System.out.printf("\n  Εδώ επιλέγετε τον αριθμό των παιχτών");
                System.out.printf("\n   με ένα να ειστε εσείς και οι υπόλιποι μποτάκια");
                System.out.printf("\n   εισάγωντας '5' πιγένεται πισω στην επιλογή παιχνιδιού");
                n=100;
            }else if(n==2){
                return n;
            }else if(n==3){
                return n;
            }else if(n==4){
                return n;
            }else if(n==5){
                return n;
            }else{
                n=100;
                System.out.printf("\n  Παρακαλώ δώστε μία σωστή επιλογή");
            }
        }
        return n;
    }
}
