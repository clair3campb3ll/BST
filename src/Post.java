
/**
 * <h1>Post Class</h1>
 * The Post class is used to create Post Object that stores the title, name and the number of likes for the object.
 * <p>
 * It implements the Comparable interface to allow for comparison based on the number of likes.
 * <p>
 * @author Claire Campbell
 */

public class Post implements Comparable<Post>{
    private String title;
    private String name;
    private int likes;
    /**
     * Creates a new Post object with the given title, author name and number of likes.
     * @param t The title of the post
     * @param n The name of the author of the post
     * @param l The number of likes the post has received
     */
    public Post(String t, String n, int l){
        title = t;
        name = n;
        likes = l;
    }
    /**
     * Returns The title of the post
     * @return String The title of the post
     */
    public String getTitle(){
        return title;
    }
    /**
     * Returns the name of the author of the post
     * @return String The name of the author of the post
     */
    public String getName(){
        return name;
    }
    /**
     * Sets the number of likes the post has received
     * @param likes The new number of likes
     */
    public void setLikes(int likes){
        this.likes = likes;
    }
    /**
     * Compares this post to another post based on the number of likes
     * @param other The other post to compare to
     * @return int A negative integer, zero, or a positive integer as this post is less than, equal to, or 
     * greater than the specified post
     */
    @Override
    public int compareTo(Post other){
        return Integer.compare(this.likes, other.likes);
    }
    /**
     * Returns a string representation of the post
     * @return String A string representation of the post
     */
    @Override
    public String toString(){
        return "Title: " + title + "\nName: " + name + "\nLikes: " + likes;
    }
}
