
/**
 * This class is used to create Post Object that stores the title, name and the number of likes for the object.
 */

public class Post implements Comparable<Post>{
    private String title;
    private String name;
    private int likes;
    
    public Post(String t, String n, int l){
        title = t;
        name = n;
        likes = l;
    }

    public String getTitle(){
        return title;
    }

    public String getName(){
        return name;
    }

    public void setLikes(int likes){
        this.likes = likes;
    }

    @Override
    public int compareTo(Post other){
        return Integer.compare(this.likes, other.likes);
    }

    @Override
    public String toString(){
        return "Title: " + title + "\nName: " + name + "\nLikes: " + likes;
    }
}
