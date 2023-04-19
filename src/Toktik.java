import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/** 
 * <h1>Toktik</h1>
 * The Toktik class is the main class that implements a simple proof-of-concept replica of some functionality
 * of a social media system like Tiktok using Binary Search Trees as the main underlying data structure.
 * <p>
 * The Toktik class creates a Binary Search Tree to store Account objects which store information on each user as well as a
 * linked list to store Post objects.
 * <p>
 * @author Claire Campbell
 */

public class Toktik {
    private static BinarySearchTree<Account> accounts;
    public static void main(String[] args) throws FileNotFoundException {
        accounts = new BinarySearchTree<Account>();
        boolean leave = false;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to TokTik!");

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
                        System.out.println("Enter an account name:");
                        String s = input.next();
                        if (s != null) {
                            if (accounts.root != null){ // checks if there are any accounts
                                Account account1 = new Account(s);
                                BinaryTreeNode<Account> node1 = accounts.find(account1);
                                if (node1 != null) { // if the account name exists
                                    account1 = node1.data;
                                    System.out.println(account1.getDescription());
                                }
                                else {
                                    System.out.println("Account does not exist!\n");
                                }
                            }
                            else {
                                System.out.println("There are no existing accounts!\n");
                            }    
                        }
                        else {
                            System.out.println("Account name cannot be blank!\n");
                        }
                        break;
                    case "2": // list all accounts
                        if (accounts.root != null){ // if there are existing accounts
                            System.out.println("Existing accounts: ");
                            accounts.levelOrder();
                        }
                        else {
                            System.out.println("There are no existing accounts!\n");
                        }
                        break;
                    case "3": // create an account
                        System.out.println("Enter an account name:");
                        String name = input.next();
                        input.nextLine();
                        System.out.println("Enter an account profile description:");
                        String description = input.nextLine();
                        Account account2 = new Account(name,description);
                        BinaryTreeNode<Account> node2 = accounts.find(account2);
                        if (node2 == null){ // if the account name doesn't already exist
                            accounts.insert(account2);
                            System.out.println("Successfully created account: " + account2.getName()+" \n");
                        }
                        else {
                            System.out.println("An account with that name already exists!\n");
                        }                  
                        break;
                    case "4": // delete an account
                        if (accounts.root != null){ // if there are existing accounts
                            System.out.println("Enter an account name:");
                            Account account3 = new Account(input.next());
                            BinaryTreeNode<Account> node3 = accounts.find(account3);
                            if (node3 != null){ // if the account name exists
                                accounts.delete(account3, node3);
                                System.out.println("Successfully deleted account: " + account3.getName()+"\n");
                            }
                            else {
                                System.out.println("Account not found!\n");
                            }   
                        }
                        else {
                            System.out.println("There are no existing accounts!\n");
                        }
                        break;
                    case "5": // display all posts for a single account
                        if (accounts.root != null) { // checks if there are no accounts
                            System.out.println("Enter an account name:");
                            Account account4 = new Account(input.next());
                            BinaryTreeNode<Account> node4 = accounts.find(account4);
                            if (node4 != null){ // if account exists
                                account4 = node4.data;
                                if (account4.getPosts().toString() != "[]"){ // if there are no posts
                                    System.out.println(account4.getPosts().toString());
                                }
                                else {
                                    System.out.println("Account " + account4.getName() + " has no posts!\n");
                                }
                                
                            }
                            else {
                                System.out.println("Account not found!\n");
                            }
                        }
                        else {
                            System.out.println("There are no existing accounts!\n");
                        }
                        break;
                    case "6": // add a new post for an account
                        if (accounts.root != null){ // if there are existing accounts
                            System.out.println("Enter an account name:");
                            Account account5 = new Account(input.next());
                            
                            BinaryTreeNode<Account> node5 = accounts.find(account5);
                            if (node5 != null) { // if the account name exists
                                input.nextLine();
                                System.out.println("Enter the post title:");
                                String title = input.nextLine();
                                System.out.println("Enter the name of the video filename:");
                                String vidName = input.nextLine();
                                System.out.println("Enter the number of likes:");
                                int likes = Integer.parseInt(input.next());
                                Post post = new Post(title, vidName, likes);
                                account5 = node5.data;
                                account5.addPost(post);
                                System.out.println("Success! Choose option 5 to view your posts!");
                            }
                            else {
                                System.out.println("Account not found!\n");
                            }
                        }
                        else {
                            System.out.println("There are no existing accounts!\n");
                        }
                        break;
                    case "7": // load a file of actions from disk and process this
                        System.out.println("Enter the filename to be loaded from disk:");
                        String filename = input.next();
                        try {
                            BufferedReader reader = new BufferedReader(new FileReader("src/"+filename));
                            String line = reader.readLine();
                            while((line = reader.readLine()) != null) { // loops until no more text is found in the textfile
                                String[] parts = line.split(" "); // splits line into an array according whitespace
                                if (parts[0].equals("Create")){
                                    // if the create account action is called in the textfile
                                    String n = parts[1];
                                    String d = line.substring(line.indexOf(n) + n.length() +1);
                                    Account account6 = new Account(n,d);
                                    accounts.insert(account6);
                                } // end if
                                else if (parts[0].equals("Add")){
                                    // if the add post to an account action is called in the textfile
                                    String n = parts[1];
                                    String vidFileName = parts[2];
                                    String numLikes = parts[3];
                                    String t = line.substring(line.indexOf(numLikes)+ numLikes.length()+1);
                                    Account account6 = new Account(n);
                                    Post p = new Post(t, vidFileName, Integer.parseInt(numLikes));
                                    BinaryTreeNode<Account> node6 = accounts.find(account6);
                                    if (node6 != null) { // if the account exists
                                        account6 = node6.data;
                                        account6.addPost(p);
                                    } // end if
                                    else {
                                        System.out.println("Account not found!\n");
                                    }
                                } // end else

                            } // end while
                            reader.close();
                            System.out.println("File successfully read and processed!");
                        } // end try 
                        catch (IOException e) {
                            // if there is an error while reading the file
                            System.out.println("Error while reading file");
                        } // end catch
                        break;
                    case "8": // quit
                        leave = true;
                        System.out.println("Bye!"); 
                        break;
                    default: // other input is received
                        System.out.println("Your choice is invalid. Choose an option from the list above!\n");
                } // end of switch   
            } catch (Exception e) {
                // if there is an error during the while loop
                System.out.println("Something went wrong: "+ e.getMessage());
            } // end of try catch block
        } // end of while loop
        input.close();
    } // end of main
   
} // end of Toktik class