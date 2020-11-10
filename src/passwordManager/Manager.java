package passwordManager;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*; //imports everything

public class Manager {
    private Scanner s = new Scanner(System.in);
    //part of syntax for scanner
    private String username;
    private String password;
    //defining variables to be used in this .java file

    //this is for centralizing all the stuff. Like if you add a password
    public Manager(String username, String password) {
        // This is a constructor
        this.username = username;
        this.password = password;
        //passing the variables into this .java file
        Scanner s = new Scanner(System.in);
        this.menu();
    }

    //Be careful! this is the menu for AFTER the password is put in
    public void menu() {
        System.out.println("\n\nWelcome to the administrator panel! Type in the number of the options below to run a line of code\n");
        System.out.println("1. Add a new account and password"); //create a new account and password
        System.out.println("2. Delete an account by typing in a username ONLY. If the username does not exist, you must reenter."); //delete your account
        //removes the value at the hashmap
        System.out.println("3. Edit a password, including your own"); //change ANY password including your own
        System.out.println("4. View a username's password by typing in their username"); //look at a specfific password
        System.out.println("5. Exit this admin panel"); //end the program

        String input;
        input = this.s.nextLine();
        String alias; //alias is essentially username
        String password;

        switch (input) {
//Case 1 is for adding a new password. This changes the password or username.
            case "1":
                AccountCreate.main(null);
                break;
//Case 2 is for removing an account. This deletes the key/username
            case "2":
                boolean valid2 = false;

                do {
                    System.out.print("Enter the username associated with the account you would like to remove: ");
                    alias = this.s.nextLine();
                    Iterator it = AccountCreate.userPass.entrySet().iterator();
                    boolean validUser = false;

                    while(it.hasNext()) {
                        Map.Entry mentry = (Map.Entry)it.next();
                        if (mentry.getKey().equals(alias)) {
                            validUser = true;
                        }
                    }

                    if (validUser) { //if account exists
                        valid2 = true;
                        AccountCreate.userPass.remove(alias); //finds password and removes it in hashmap
                        System.out.println("");
                        System.out.println("Account removed.");
                    } else {
                        System.out.println("This account does not exist.\n");
                    }
                } while (!valid2);

                menu(); //brings you back to the main menu
                break;
//Case 3 is for editing a password (either yours or another accounts)
            case "3":
                boolean choiceValid = true;
                String edit;
                boolean valid3 = false;

                do { //if input choice is valid
                    System.out.println("Choose what password you want to edit: ");
                    System.out.println("1. Edit another accounts password");
                    System.out.println("2. Edit your own password");
                    System.out.println("3. Go back");
                    edit = s.nextLine();

                    switch(edit) {
                        case "1": // change another accounts password
                            do {
                                System.out.print("Enter the username of the account whose password you would like to edit:");
                                alias = s.nextLine();
                                //to check if account exists
                                Iterator it = AccountCreate.userPass.entrySet().iterator();
                                boolean validUser = false;

                                while(it.hasNext()) {
                                    Map.Entry mentry = (Map.Entry)it.next();
                                    if (mentry.getKey().equals(alias)) {
                                        validUser = true;
                                    }
                                }

                                if (validUser) { //if account exists
                                    boolean replaceValid = true;

                                    do { //if new password is valid
                                        valid3 = true;
                                        System.out.println("");
                                        System.out.print("Enter what you would like the password to be changed to (password must be a 6-digit hex code): ");
                                        password = this.s.nextLine();
                                        System.out.println("");

                                        if (AccountCreate.hexCheck(password)) {
                                            AccountCreate.userPass.replace(alias, password); //changes value of username and password in hashmap.
                                            System.out.println("Password edited.");
                                            replaceValid = true;
                                        } else {
                                            replaceValid = false;
                                        }
                                    } while (!replaceValid);
                                } else {
                                    System.out.println("That username does not exist.\n");
                                }
                            } while (!valid3);

                            menu(); // brings you back to manager menu
                            break;
                        case "2": //change the password you are currently logged in with
                            Scanner s = new Scanner(System.in);
                            System.out.println("Enter a new password: ");
                            String newPasswd = s.nextLine();
                            //This is the password that will be changed for UsernameChecker.username
                            AccountCreate.userPass.replace(this.username, newPasswd); //changes the password to the newly scanned one
                            //Use .replace for easy reading. Also, this.username = UsernameChecker.username therefore this will refer to a key in the userPass hashmap.
                            //How will we modify the object?
                            System.out.println("\nYour password has been updated. Return to the main menu then login again to test your new password.\n\n");
                            menu(); //brings you back to the manager menu
                            break;
                        case "3":
                            menu();
                            break;
                        default:
                            // For unexpected input
                            System.out.println("Please enter an option [1/2/3]");
                            choiceValid = false;
                    }
                } while (!choiceValid); //in case you did not enter a correct choice it will reprint the menu.
                break;
//Case 4 is for viewing a password for a username->remove if you don't want control over all accounts
            case "4":
                boolean valid4 = false;
                do {
                    System.out.print("Enter the username for the password you would like to view: ");
                    alias = this.s.nextLine();
                    Iterator it = AccountCreate.userPass.entrySet().iterator();
                    boolean validUser = false;

                    while(it.hasNext()) {
                        Map.Entry mentry = (Map.Entry)it.next();
                        if (mentry.getKey().equals(alias)) {
                            validUser = true;
                        }
                    }

                    if (validUser) { //if username exists
                        valid4 = true;
                        password = AccountCreate.userPass.get(alias);
                        System.out.println("Password: " + password);
                    } else {
                        System.out.println("This Username does not exist.");
                    }
                } while (!valid4);

                menu(); // brings you back to manager menu
                break;
//Case 5 is goes back to the menu from Main.java
            case "5":
                System.out.print("\033[H\033[2J");
                System.out.flush(); //clears the terminal
                System.out.println("Exiting...<3\n");
                HexMain.main(null); //brings you back to the main menu
                //System.exit(0); to end program
                break;
            default:
                System.out.println("Please enter an option [1/2/3/4/5]");
                menu(); //reprints menu
        }
    }
}