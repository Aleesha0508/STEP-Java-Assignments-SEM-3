package week_7.lab;

public class MovieStreamingPlatform {
    public static void main(String[] args) {
        Content[] contents = {new Movie(), new TVSeries(), new Documentary()};
        for (Content c : contents) {
            c.play();
            if (c instanceof Movie) {
                ((Movie)c).showRating();
            } else if (c instanceof TVSeries) {
                ((TVSeries)c).nextEpisode();
            } else if (c instanceof Documentary) {
                ((Documentary)c).relatedContent();
            }
        }
    }
}
class Content {
    void play() {
        System.out.println("Playing content.");
    }
}
class Movie extends Content {
    void showRating() {
        System.out.println("Movie rating: PG-13");
    }
}
class TVSeries extends Content {
    void nextEpisode() {
        System.out.println("Next episode is coming soon!");
    }
}
class Documentary extends Content {
    void relatedContent() {
        System.out.println("Showing related educational content.");
    }
}
