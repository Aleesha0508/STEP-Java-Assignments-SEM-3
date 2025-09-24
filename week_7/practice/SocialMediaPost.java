package week_7.practice;

public class SocialMediaPost {
    protected String content;
    protected String author;
    public SocialMediaPost(String content, String author) {
        this.content = content;
        this.author = author;
    }
    public void share() {
        System.out.println("Sharing " + content + " by " + author);
    }
}