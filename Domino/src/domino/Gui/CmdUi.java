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
        try{
            int key=100;
            while(key!=0){
                System.out.printf("\nΜπρορείτε να γράψτε 'βοήθεια' σε κάθε στηγμή.");
                System.out.printf("\n(1) - Παίξτε ένα παιχνίδι");
                System.out.printf("\n(2) - Επιλογές");
                System.out.printf("\n(3) - Έξοδος\n");
                nextCommand=scan.next();
                scan.reset();
                //System.out.printf("\n%s",nextCommand);
                key=Integer.parseInt(nextCommand);
                
                System.out.printf("\n%d",key);
                if (nextCommand.equals("βοηθεια")||nextCommand.equals("βοηθεια")){
                    System.out.printf("\nΒάλτε τον αριθμό στη παρένθεση για να κάνετε την επιλογή σας");
                    System.out.printf("\nΣτο (1) Αρχίζετε ένα παιχνίδι ντόμινο");
                    System.out.printf("\nΣτο (2) Μπορείτε να αλλάξετε τη γλώσσα");
                    System.out.printf("\nΣτο (3) Βγαίνετε από την εφαρμογή\n");
                }else if(key==1){
                    
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
                    System.out.printf("\nΕίστε σίγουρος ότι θέλετε να βγείτε;(ν/ο)\n");
                    nextCommand=scan.next();
                    if(nextCommand.equals("ν")){
                        key=0;
                        greekOrEnglish=2;
                    }else{
                        key=100;
                    }
                }
            }
        }catch(NumberFormatException e){
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
                //scan = new Scanner(System.in);
                nextCommand=scan.next();
                //System.out.printf("\n%s",nextCommand);
                scan.nextLine();
                key=Integer.parseInt(nextCommand);
            }catch(NumberFormatException e){
                }
            if (nextCommand.equalsIgnoreCase("help")){
                System.out.printf("\nYou enter the number in the parenthesis to pick your choice");
                System.out.printf("\nIn (1) you start a game of domino");
                System.out.printf("\nIn (2) you can change the language");
                System.out.printf("\nIn (3) you exit the application\n");
            }else if(key==1){

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
            }
        }
        return key;        
    }
}
