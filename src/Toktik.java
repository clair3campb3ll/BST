import java.io.FileNotFoundException;
import java.util.Scanner;

public class Toktik {
    private static BinarySearchTree<Account> accounts;

    public static void main(String[] args) throws FileNotFoundException {
        accounts = new BinarySearchTree<Account>();
        Scanner input = new Scanner(System.in);
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
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    System.out.println("Bye!"); 
                    break;
                default:
                    System.out.println("Choose an option from the list above!");

            }    
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Something went wrong.");
        }

    }


    
    
}
