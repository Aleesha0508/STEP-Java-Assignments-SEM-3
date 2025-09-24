package week_7.homework;

public class ArtGallery {
    public static void main(String[] args) {
        ArtWork art = new Painting();
        art.display();
        if (art instanceof Painting) ((Painting)art).brushTechnique();
        art = new Sculpture();
        art.display();
        if (art instanceof Sculpture) ((Sculpture)art).materialDetails();
    }
}
class ArtWork {
    void display() {
        System.out.println("Displaying artwork");
    }
}
class Painting extends ArtWork {
    void brushTechnique() {
        System.out.println("Painting with brush technique");
    }
}
class Sculpture extends ArtWork {
    void materialDetails() {
        System.out.println("Sculpture made of marble");
    }
}
class DigitalArt extends ArtWork {
    void resolution() {
        System.out.println("Digital art at 4K resolution");
    }
}
