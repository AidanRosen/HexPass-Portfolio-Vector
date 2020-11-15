package passwordManager;

import vector_calc.VectorControl;

import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;

import java.awt.Color;


//This class is for comparing passwords to strings
//It does not use objects yet.
class Passcheck{
    //NEED to know how to control namespaces with instanced variables!
    //Like, how to make a password string here AND in main
    public static void passCheck(){
        //This MUST be the same name as the class to work
        //System.out.println("code in Passcheck working");
        Scanner myObj = new Scanner(System.in);
        //^ this is important! it enables user input from java.util
        //String dummy = "dummy"; old code
        //Dummy will be replaced with the actual password variable
        String passTest;
        //Initialized this way to be used later
        int attempts = 7;

        //Do I need this to be a static or object or....
        //NEED to know when to use an object.
      /*

    }
      OK so while loops are VERY different in Java. Need a do... while loop
    */
        do {
            System.out.println("\n\nWhat is your password for " + UsernameChecker.username + "?");
            passTest = myObj.nextLine();
            //This compares the string input to the password
            boolean truePass = passTest.equals(AccountCreate.userPass.get(UsernameChecker.username));
            //.get puts in the key and gets the value back (the password)
            //we use UsernameChecker.username because that's where we copy over the username key.
            //This is all defined in the boolean truePass for the sake of concision. The parameter in passTest.equals()
            if (truePass){
                System.out.println("You got it!");

                //commenting here to avoid errors with IDE. HOWEVER it isn't dead code... it just needs to be used elsewhere
                System.out.println("This Username Exists!");
                System.out.print("\033[H\033[2J");
                animation();
                ColoredWindow frame = new ColoredWindow(passTest);
                Manager m = new Manager(UsernameChecker.username, AccountCreate.userPass.get(UsernameChecker.username)); //initializes Manager object with the username from UsernameChecker and the password from the hashmap
            }
            else {
                System.out.println("Incorrect password");
                attempts -= 1;
                System.out.println("You have " + attempts + " attempts left");
            }
        } while (attempts > 0 && !passTest.equals(AccountCreate.userPass.get(UsernameChecker.username)));
        //Have to basically replace the above with the whole thing for boolean truePass to test for equality properly
        if (attempts < 1) {
            System.out.println("You have run out of attempts. This account, " + UsernameChecker.username + " has been deleted");
            AccountCreate.userPass.remove(UsernameChecker.username);
        }
    }

    private static void animation() { //ascii animation
        char[][] heart = new char[][] {
                new char[] {',', 'd', '8', '8', 'b', '.', 'd', '8', '8', 'b', ','},
                new char[] {'8', '8', '8', '8','8', '8', '8', '8','8', '8', '8'},
                new char[] {'`', 'Y', '8', '8', '8', '8', '8', '8', '8', 'Y', '\''},
                new char[] {' ', ' ', '`', 'Y', '8', '8', '8', 'Y', '\'', ' ', ' '},
                new char[] {' ', ' ', ' ', ' ', '`', 'Y', '\'', ' ', ' ', ' ', ' '}
        };

        char[][] heartInv = new char[][] {
                new char[] {' ', ' ', ' ', ' ', '/', 'Y', '\'', ' ', ' ', ' ', ' '},
                new char[] {' ', ' ', '\'', '/','8', '8', '8', '\\', '\'', ' ', ' '},
                new char[] {'\'', '/', '8', '8', '8', '8', '8', '8', '8', '\\', '`'},
                new char[] {'0', '8', '8', '8', '8', '8', '8', '8', '8', '8', '0'},
                new char[] {' ', '\'', '.', 'd', '8', '\'', '8', 'b', '.', '/', ' '},
                new char[] {' ', ' ', ' ', '\'', ' ', ' ', ' ', '\'', ' ', ' ', ' '}
        };

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(heart[i][j]);
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(heartInv[i][j]);
            }
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }
    public static void main(String[] args)  {

        passCheck();

        System.out.print("\033[H\033[2J");
        System.out.flush();
        HexMain.main(null);
    }
}