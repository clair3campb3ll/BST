/**
 * 
 */
import java.util.LinkedList;

public class Account implements Comparable<Account>{
    private String name;
    private String description;
    private LinkedList<Post> posts;

    public Account(String n){
        name = n;
        description = "";
        posts = new LinkedList<>();
    }

    public Account(String n, String d){
        name = n;
        description = d;
        posts = new LinkedList<>();
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void addPost(Post post){
        posts.add(post);
    }

    public LinkedList<Post> getPosts(){
        return posts;
    }

    public int compareTo(Account another) {
        return name.compareTo(another.name);
    }

    public String toString(){
        return "Name: " + name + "\nDescription: " + description;
    }
}
