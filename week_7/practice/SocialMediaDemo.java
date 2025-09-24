package week_7.practice;

public class SocialMediaDemo {
    public static void main(String[] args) {
        SocialMediaPost[] posts = new SocialMediaPost[3];
        posts[0] = new InstagramPost("Sunset vibes!", "johndoe", 245);
        posts[1] = new TwitterPost("Java is awesome!", "codeninja", 89);
        posts[2] = new SocialMediaPost("Hello world!", "beginner");
        for (SocialMediaPost post : posts) {
            post.share();
        }
    }
}

