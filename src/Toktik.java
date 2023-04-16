import java.io.FileNotFoundException;
import java.util.Scanner;

public class Toktik {
    private static BinarySearchTree<Account> accounts;

    public static void main(String[] args) throws FileNotFoundException {
        accounts = new BinarySearchTree<Account>();
        boolean leave = false;
        Scanner input = new Scanner(System.in);

        while(!leave) {
            System.out.println("Choose an action from the menu:");
            System.out.println("1. Find the profile description for a given account");
            System.out.println("2. List all accounts");
            System.out.println("3. Create an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Display all posts for a single account");
            System.out.println("6. Add a new post for an account");
            System.out.println("7. Load a file of actions from disk and process this");
            System.out.println("8. Quit");
            System.out.println("Enter your choice: ");

            String choice = input.next();

            try {
                switch(choice) {
                    case "1": // find profile description
                        break;
                    case "2": // list all accounts
                        break;
                    case "3": // create an account
                        createAccount();                        
                        break;
                    case "4": // delete an account
                        break;
                    case "5": // display all posts for a single account
                        
                        break;
                    case "6": // add a new post for an account
                        break;
                    case "7": // load a file of actions from disk and process this
                        break;
                    case "8": // quit
                        leave = true;
                        System.out.println("Bye!"); 
                        break;
                    default: // other input is received
                        System.out.println("Your choice is invalid. Choose an option from the list above!");
                } // end of switch   
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            } // end of try catch block
        } // end of while loop
    } // end of main

    public static void createAccount(){
        System.out.println("Enter an account name");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("Enter an account profile description");
        String description = input.nextLine();
        Account account = new Account(name,description);
        System.out.println("Account successfully created");
    }

    public static void deleteAccount(){
        System.out.println("Enter an account name");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        
    }

    
    
} // end of Toktik class
