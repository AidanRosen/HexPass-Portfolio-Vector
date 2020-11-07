//Menu option 1
//Alex
package passwordManager;
import passwordManager.HexMain;

import java.util.*; //imports everything

public class AccountCreate {
    private static Scanner input = new Scanner(System.in);
    public static String user = null;
    public static String pass = null;
    public static HashMap<String, String> userPass = new HashMap<String, String>();

    public static void checkUser() {
        user = input.nextLine();
        Iterator it = userPass.entrySet().iterator(); //iteration: unit 4
        //entrySet creates a copy of the hashmap; iterator can only access entryset and not the hashmap directly
        boolean validUser = true;

        while(it.hasNext()) { //iterate through hashmap
            Map.Entry mentry = (Map.Entry)it.next(); //cannot get the values directly from the iterator but rather have to send the values from the iterator (it.next) to the map.entry
            if (mentry.getKey().equals(user)) { //check if username is already taken
                validUser = false;
            }
        }

        if (validUser) {
            System.out.println("Your username is now \"" + user + "\"");
        } else {
            System.out.println("This username is already taken. Please try again:");
            checkUser(); //recursion
        }
    }

    public static boolean hexCheck(String pass) {

        if (pass.length() == 6) { //check if password length is 6
            for (int i = 0; i < pass.length(); i++) {
                if (pass.charAt(i) != '1' && pass.charAt(i) != '2' && pass.charAt(i) != '3' && pass.charAt(i) != '4' && pass.charAt(i) != '5' && pass.charAt(i) != '6' && pass.charAt(i) != '7' && pass.charAt(i) != '8' && pass.charAt(i) != '9' && pass.charAt(i) != '0' && pass.charAt(i) != 'a' && pass.charAt(i) != 'b' && pass.charAt(i) != 'c' && pass.charAt(i) != 'd' && pass.charAt(i) != 'e' && pass.charAt(i) != 'f') {                   //I know there's probably a better way to do this, unfortunately there doesn't seem to be a parseHex to check for numberformateexception
                    System.out.println("Password must be a hex number. Try again: ");
                    return false;
                }
            }
        } else {
            System.out.println("Password must be 6 digits long. Try again: ");
            return false;
        }

        return true;
    }

    public static void checkPass() {
        pass = input.nextLine();
        String passCheckString = pass.toLowerCase();

        if (hexCheck(passCheckString)) {
            userPass.put(user, pass); //put into hashmap
            HexMain.accountMade = true;
        } else {
            checkPass();
        }
    }

    public static void main (String[] args) {
        System.out.println("Please choose a username: ");
        checkUser();
        System.out.println("\nPlease choose a password (password must be a 6-digit hexadecimal number): ");
        checkPass();
        System.out.println("Your password has been set.");
        HexMain.main(null);
    }
}