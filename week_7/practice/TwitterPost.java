package week_7.practice;

public class TwitterPost extends SocialMediaPost {
    private int retweets;
    public TwitterPost(String content, String author, int retweets) {
        super(content, author);
        this.retweets = retweets;
    }
    @Override
    public void share() {
        System.out.println("Tweet: " + content + " by " + author + " - retweets " + retweets);
    }
}