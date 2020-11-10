package passwordManager;//Imports scanner class
import java.util.Scanner;

class UsernameChecker {
    // Creating necessary variables. Using "cslover12" as a sample username in this class
    public static String username = "cslover12";
    //BUT username has a CAPITAL N <--- previous error
    public static String yes = "This Username Exists!";
    public static String no = "The Username Does Not Exist";

    public static void main(String[] args) {
        System.out.println("You are now logging in with a username. ");
        //signal for transition
        Scanner input = new Scanner(System.in);
        System.out.println("What's your username?");
        username = input.nextLine();
        //Now, instead of username always being cslover12, it can now be put input by the user
        //We keep cslover way up at the top for 1. documentation 2. so that the string exists before we manipulate it
        //and used by the system like below in the boolean usernameExists


        //This is the point at which the user inputs the username, correct or not
        //MUST use AccountCreate.userPass to refer to the static variable!
        boolean usernameExists = AccountCreate.userPass.containsKey(username);
        //The above method checks if the username exists within the hashmap created under AccountCreate.java
        if(usernameExists == true){
            //we use a boolean in the above. True means the username exists in the hashmap as a key, hence the name, usernameExists
            System.out.println(yes);
            Passcheck.main(null);
        }
        else{
            System.out.println(no);
        }
    }
}