import java.util.LinkedList;

import java.util.LinkedList;

public class Account implements Comparable<Account>{
    private String name;
    private String description;
    private LinkedList<Post> posts;

    public Account(String n, String d){
        name = n;
        description = d;
    }

    public int compareTo(Account another) {
        return name.compareTo(another.name);
    }

    public String toString(){
        return name;
    }
}
