import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 */

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
                        System.out.println("Enter an account name: ");
                        if (input.next() != null){
                            if (accounts.root != null){
                                Account account1 = new Account(input.next());
                                BinaryTreeNode<Account> node1 = accounts.find(account1);
                                if (node1 != null) {
                                    account1 = node1.data;
                                    System.out.println(account1.getDescription());
                                }
                                else {
                                    System.out.println("Account does not exist!");
                                } 
                            }
                            else {
                                System.out.println("There are no existing accounts!");
                            }
                        }
                        else{
                            System.out.println("Account name cannot be blank!");
                        }
                        break;
                    case "2": // list all accounts
                        if (accounts.root != null){
                            System.out.println("Existing accounts: ");
                            accounts.levelOrder();
                        }
                        else {
                            System.out.println("There are no existing accounts!");
                        }
                        break;
                    case "3": // create an account
                        System.out.println("Enter an account name: ");
                        String name = input.next();
                        System.out.println("Enter an account profile description: ");
                        String description = input.next();
                        Account account2 = new Account(name,description);
                        BinaryTreeNode<Account> node2 = accounts.find(account2);
                        if (node2 == null){
                            accounts.insert(account2);
                            System.out.println("Successfully created account: " + account2.getName());
                        }
                        else {
                            System.out.println("An account with that name already exists!");
                        }                     
                        break;
                    case "4": // delete an account
                        if (accounts.root != null){
                            System.out.println("Enter an account name");
                            Account account3 = new Account(input.next());
                            BinaryTreeNode<Account> node3 = accounts.find(account3);
                            if (node3 != null){
                                accounts.delete(account3, node3);
                                System.out.println("Successfully deleted account " + account3.getName());
                            }
                            else {
                                System.out.println("Account not found!");
                            }   
                        }
                        else {
                            System.out.println("There are no existing accounts");
                        }
                        break;
                    case "5": // display all posts for a single account
                        if (accounts.root != null) {
                            System.out.println("Enter an account name");
                            Account account4 = new Account(input.next());
                            BinaryTreeNode<Account> node4 = accounts.find(account4);
                            if (node4 != null){
                                account4 = node4.data;
                                System.out.println(account4.getPosts().toString());
                            }
                            else {
                                System.out.println("Account not found!");
                            }
                        }
                        else {
                            System.out.println("There are no existing accounts!");
                        }
                        break;
                    case "6": // add a new post for an account
                        if (accounts.root != null){
                            System.out.println("Enter an account name");
                            Account account5 = new Account(input.next());
                            System.out.println("Enter the post title:");
                            String title = input.next();
                            System.out.println("Enter the name of the video filename:");
                            String vidName = input.next();
                            System.out.println("Enter the number of likes:");
                            int likes = input.nextInt();
                            //BinaryTreeNode<Account> node4 = accounts.find(account4);
                            Post post = new Post(title, vidName, likes);
                            BinaryTreeNode<Account> node5 = accounts.find(account5);
                            if (node5 != null) {
                                account5 = node5.data;
                                account5.addPost(post);
                            }
                            else {
                                System.out.println("Account not found!");
                            }
                        }
                        else {
                            System.out.println("There are no existing accounts!");
                        }
                        break;
                    case "7": // load a file of actions from disk and process this
                        System.out.println("Enter the filename to be loaded from disk:");
                        String filename = input.next();
                        try {
                            //File file = new File(filename);
                            //Scanner fileReader = new Scanner(file);

                            BufferedReader reader = new BufferedReader(new FileReader("src/"+filename));
                            String line = reader.readLine();
                            while((line = reader.readLine()) != null) {
                                String[] parts = line.split(" ");
                                if (parts[0].equals("Create")){
                                    String n = parts[1];
                                    String d = line.substring(line.indexOf(n) + n.length() +1);
                                    Account account6 = new Account(n,d);
                                    accounts.insert(account6);
                                } // end if
                                else if (parts[0].equals("Add")){
                                    String n = parts[1];
                                    String vidFileName = parts[2];
                                    System.out.println(vidFileName);
                                    //String numLikes = parts[3];
                                    String numLikes = parts[3];
                                    String t = line.substring(line.indexOf(numLikes)+ numLikes.length()+1);
                                    System.out.println(t);
                                    Account account6 = new Account(n);
                                    Post p = new Post(t, vidFileName, Integer.parseInt(numLikes));
                                    BinaryTreeNode<Account> node6 = accounts.find(account6);
                                    if (node6 != null) {
                                        account6 = node6.data;
                                        account6.addPost(p);
                                    } // end if
                                    else {
                                        System.out.println("Account not found!");
                                    }
                                } // end else

                            } // end while
                            reader.close();
                            //fileReader.close();
                        } // end try 
                        catch (IOException e) {
                            System.out.println("Error while reading file");
                        } // end catch
                        break;
                    case "8": // quit
                        leave = true;
                        System.out.println("Bye!"); 
                        break;
                    default: // other input is received
                        System.out.println("Your choice is invalid. Choose an option from the list above!");
                } // end of switch   
            } catch (Exception e) {
                System.out.println("Something went wrong."+ e.getMessage());
            } // end of try catch block
        } // end of while loop
        input.close();
    } // end of main
} // end of Toktik class