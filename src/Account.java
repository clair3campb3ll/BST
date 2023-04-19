/** 
 * <h1>Account Class</h1>
 * The Account class when instantiated creates an Account class which represents a user account, which has an account name, 
 * description and posts. The posts are stored in a linked list.
 * <p>
 * This class implements the Comparable interface to enable comparison of Account objects based on their account name.
 * <p>
 * @author Claire Campbell
 */

import java.util.LinkedList;

public class Account implements Comparable<Account>{
    private String name;
    private String description;
    private LinkedList<Post> posts;

    /**
     * Creates an Account object with the given account name and an empty description
     * @param n The name of the account
     */
    public Account(String n){
        name = n;
        description = "";
        posts = new LinkedList<>();
    }
    /**
     * Creates an Account object with the given account name and description.
     * @param n The account name
     * @param d The account description
     */
    public Account(String n, String d){
        name = n;
        description = d;
        posts = new LinkedList<>();
    }

    /**
     * Returns the name of the account
     * @return String The name of the account as a String
     */
    public String getName(){
        return name;
    }

    /**
     * Returns the description of the account
     * @return String The description of the account as a String
     */
    public String getDescription(){
        return description;
    }

    /**
     * Adds a new post to the linked list of posts
     * @param post The post to be added to the linked list of posts
     */
    public void addPost(Post post){
        posts.add(post);
    }

    /**
     * Returns the linked list of posts
     * @return LinkedList The linked list of posts
     */
    public LinkedList<Post> getPosts(){
        return posts;
    }

    /**
     * Compares the account name of this Account object with that of another Account object
     * @param another The Account object to be compared
     * @return int 0 if the account names are equal, a positive integer if the account name of this Account object is greater 
     * than that of another, and a negative integer if the account name of this Account object is less than that of another
     */
    public int compareTo(Account another) {
        return name.compareTo(another.name);
    }
    /**
     * Returns a String representation of the Account object
     * @return String A String representation of the Account object in the format "Name: [name]\nDescription: [description]"
     */
    public String toString(){
        return "Name: " + name + "\nDescription: " + description;
    }
}
