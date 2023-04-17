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
                        System.out.println("Enter an account name");
                        Account account1 = new Account(input.nextLine());
                        BinaryTreeNode<Account> node1 = accounts.find(account1);
                        account1 = node1.data;
                        System.out.println(account1.getDescription());
                        break;
                    case "2": // list all accounts
                        accounts.levelOrder();
                        break;
                    case "3": // create an account
                        System.out.println("Enter an account name");
                        String name = input.nextLine();
                        System.out.println("Enter an account profile description");
                        String description = input.nextLine();
                        Account account2 = new Account(name,description);
                        BinaryTreeNode<Account> node2 = accounts.find(account2);
                        if (node2 == null){
                            accounts.insert(account2);
                            System.out.println("Successfully created account "+account2.getName());
                        }
                        else {
                            System.out.println("An account with that name already exists!");
                        }                     
                        break;
                    case "4": // delete an account
                        System.out.println("Enter an account name");
                        Account account3 = new Account(input.nextLine());
                        BinaryTreeNode<Account> node3 = accounts.find(account3);
                        accounts.delete(account3, node3);
                        System.out.println("Successfully deleted account "+account3.getName());
                        break;
                    case "5": // display all posts for a single account
                        System.out.println("Enter an account name");
                        Account account4 = new Account(input.nextLine());
                        BinaryTreeNode<Account> node4 = accounts.find(account4);
                        account4 = node4.data;
                        account4.getPosts();

                        break;
                    case "6": // add a new post for an account
                        System.out.println("Enter an account name");
                        Account account5 = new Account(input.nextLine());
                        System.out.println("Enter the post title:");
                        String title = input.nextLine();
                        System.out.println("Enter the name of the video filename:");
                        String vidName = input.nextLine();
                        System.out.println("Enter the number of likes:");
                        int likes = input.nextInt();
                        //BinaryTreeNode<Account> node4 = accounts.find(account4);
                        Post post = new Post(title, vidName, likes);
                        account5.addPost(post);
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
} // end of Toktik class
