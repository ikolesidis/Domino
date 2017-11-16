/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domino.Clii;
import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author Ilias Kolesidis
 */
public class DominoCli {
    private Scanner scan=  new Scanner(System.in);
    private String nextCommand;
    private Locale country;
    private int greekOrEnglish; //greek is 0 english is 1, 2 is exit
    private CliHelp help = new CliHelp();
    
    public void startCli(){
        scan.useDelimiter("\n");
        country= Locale.getDefault();
        if(country.getCountry().equals("GR")){
            greekOrEnglish=0;
            help.language=0;
        }else{
            greekOrEnglish=1;
            help.language=1;
        }
        while(greekOrEnglish!=2){
            menu();
        }
    }
    private void menu(){
        if (greekOrEnglish==0){
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
                    help.help(0);
                }else if(key==1){
                    gamesSelect();
                }else if(key==2){
                    //greekOrEnglish=0;
                    //help.language=0;
                    key=settings();
                    while(key!=3){
                        if(key==2){
                            greekOrEnglish=0;
                            help.language=0;
                            key=settings();
                        }else if(key==1){
                            greekOrEnglish=1;
                            help.language=1;
                            key=settings();
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
        }else if(greekOrEnglish==1){
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
                    help.help(0);
                }else if(key==1){
                    gamesSelect();
                }else if(key==2){
                    //greekOrEnglish=1;
                    //help.language=1;
                    key=settings();
                    while(key!=3){
                        if(key==2){
                            greekOrEnglish=0;
                            help.language=0;
                            key=settings();
                        }else if(key==1){
                            greekOrEnglish=1;
                            help.language=1;
                            key=settings();
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
    }
    private int settings(){
        if (greekOrEnglish==0){
            try{
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
            }catch (NumberFormatException e){
                if (nextCommand.equalsIgnoreCase("βοηθεια")||nextCommand.equalsIgnoreCase("βοηθεια")){
                    help.help(1);
                }
            }
        }else if (greekOrEnglish==1){
            try{
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
            }catch (NumberFormatException e){
                if (nextCommand.equalsIgnoreCase("help")){
                    help.help(1);
                }
            }
            }
            return -1;
    }

    private void gamesSelect(){
        if (greekOrEnglish==0){
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
                    help.help(2);
                }else if(n==1){
                    //start solo1()
                    n=0;
                }else if(n==2){
                    n=selectNumberOfPlayers();
                    if(n!=5){
                        //start hungarian(n)
                        n=0;
                    }else{
                        n=100;
                    }
                }else if(n==3){
                    n=selectNumberOfPlayers();
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
        }else if(greekOrEnglish==1){
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
                    help.help(2);
                }else if(n==1){
                    // start solo1()
                    n=0;
                }else if(n==2){
                    n=selectNumberOfPlayers();
                    if (n!=5){
                        //start hungarianGame(n)
                        n=0;
                    }else{
                        n=100;
                    }
                }else if(n==3){
                    n=selectNumberOfPlayers();
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
    }
    
    private int selectNumberOfPlayers(){
        if (greekOrEnglish==0){
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
                    help.help(3);
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
        }else if(greekOrEnglish==1){
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
                    help.help(3);
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
            return -1;
    }
}
