package passwordManager;

import java.util.Scanner;
import java.util.InputMismatchException;
//need this for user input with


public class HexMain {

    public HexMain (){
        HexMain.main(null);
    }

    public static boolean accountMade = false;

    public static void main(String[] args) throws InputMismatchException /*throws IOException*/ {
        //accepts user input for INTEGERS
        Scanner choice = new Scanner(System.in);
        //hashmap initialization needed, see below
        System.out.println("\n\nWelcome to the main menu OF PASSWORD MANAGERER with an -er");
        System.out.println("1. Account creation");
        if (accountMade){
            System.out.println("2. Username login");
        }
        System.out.println("3. End the program");
        System.out.println("\nWhich menu option do you want to run? Type a number and a number only\n");


        int menuOption = 0;
        try{
            menuOption = choice.nextInt();
        }
        catch(InputMismatchException e){
            System.out.println("You must type in a number");
            main(null);
        }
        //int menuOption = choice.nextInt();
        switch (menuOption){
            case 1:
                AccountCreate.main(null);

                //this causes it to run twice
                //WHY is it going over into UsernameChecker...?
                break; //<--- we use break so that the switch case discontinues
            //We don't want it to go straight to case 2.
            case 2:
                if (accountMade){
                    UsernameChecker.main(null);}
                break;
            case 3:
                System.out.print("\033[H\033[2J");
                System.out.println("Exiting...<3");
                System.exit(0);
                break;
            default:
                System.out.println("You did not use a proper number. Type in the number of the option you want to run");
                main(null); //re-prints menu options
                //We use this in the event that the case doesn't = 1 or 2
        }
    }
}

/* hashmap initialization required in main.java
 HashMap<String, String> userPass = new HashMap<String, String>();
*/

/* enter values into hashmap
  userPass.put("user", "pass");
*/

/* get value at key "pass"
  String var= userPass.get(user);
*/

/* hashmap iteration
  Iterator it = userPass.entrySet().iterator();

  while(it.hasNext()) {
    Map.Entry mentry = (Map.Entry)it.next(); //cannot get the values directly from the iterator but rather have to send the values from the iterator (it.next) to the map.entry
    System.out.print("key is: " + mentry.getKey()); //find key
    System.out.println("value is: " + mentry.getValue()); //find value
    }

*/
