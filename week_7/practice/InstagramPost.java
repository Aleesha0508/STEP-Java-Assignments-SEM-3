package week_7.practice;

public class InstagramPost extends SocialMediaPost {
    private int likes;
    public InstagramPost(String content, String author, int likes) {
        super(content, author);
        this.likes = likes;
    }
    @Override
    public void share() {
        System.out.println("Instagram: " + content + " by " + author + " - likes " + likes);
    }
}