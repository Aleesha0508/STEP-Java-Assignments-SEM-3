package week_7.lab;

public class SocialMediaFeed {
    public static void main(String[] args) {
        SocialMediaPost[] posts = {
            new InstagramPost("Sunset vibes", "Alice", 200),
            new TwitterPost("Java rocks!", "Bob", 50),
            new LinkedInPost("Networking tips", "Carol", 300)
        };
        for (SocialMediaPost post : posts) post.displayPost();
    }
}
class SocialMediaPost {
    protected String content;
    protected String author;
    public SocialMediaPost(String content, String author) {
        this.content = content;
        this.author = author;
    }
    void displayPost() {
        System.out.println(author + " posted: " + content);
    }
}
class InstagramPost extends SocialMediaPost {
    private int likes;
    public InstagramPost(String content, String author, int likes) {
        super(content, author);
        this.likes = likes;
    }
    @Override
    void displayPost() {
        System.out.println("Instagram: " + content + " by " + author + " #likes: " + likes);
    }
}
class TwitterPost extends SocialMediaPost {
    private int retweets;
    public TwitterPost(String content, String author, int retweets) {
        super(content, author);
        this.retweets = retweets;
    }
    @Override
    void displayPost() {
        System.out.println("Twitter: " + content + " by " + author + " #retweets: " + retweets);
    }
}
class LinkedInPost extends SocialMediaPost {
    private int connections;
    public LinkedInPost(String content, String author, int connections) {
        super(content, author);
        this.connections = connections;
    }
    @Override
    void displayPost() {
        System.out.println("LinkedIn: " + content + " by " + author + " #connections: " + connections);
    }
}

