package week_8.homework;

// Topic 2: Interface Implementation in Multiple Classes

interface Playable {
    void play();
    void pause();
}

class MusicPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Music is playing...");
    }

    @Override
    public void pause() {
        System.out.println("Music paused.");
    }
}

class VideoPlayer implements Playable {
    @Override
    public void play() {
        System.out.println("Video is playing...");
    }

    @Override
    public void pause() {
        System.out.println("Video paused.");
    }
}

public class PlayerTest {
    public static void main(String[] args) {
        Playable p1 = new MusicPlayer();
        p1.play();
        p1.pause();

        Playable p2 = new VideoPlayer();
        p2.play();
        p2.pause();
    }
}
