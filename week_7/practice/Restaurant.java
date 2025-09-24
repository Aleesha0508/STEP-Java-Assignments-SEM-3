package week_7.practice;

public class Restaurant {
    protected String name;
    public Restaurant(String name) {
        this.name = name;
    }
    public void prepareFood() {
        System.out.println(name + " is preparing generic food");
    }
    public void estimateTime() {
        System.out.println("Estimated time: 30 minutes");
    }
}