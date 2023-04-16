public class Post {
    private String title;
    private String name;
    private int likes;
    
    public Post(String t, String n, int l){
        title = t;
        name = n;
        likes = l;
    }

    public String toString(){
        return title + "/n" + name + "/n" + likes;
    }
}
