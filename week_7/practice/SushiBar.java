package week_7.practice;

public class SushiBar extends Restaurant {
    public SushiBar(String name) {
        super(name);
    }
    @Override
    public void prepareFood() {
        System.out.println(name + " is crafting fresh sushi with precision!");
    }
    @Override
    public void estimateTime() {
        System.out.println("Sushi will be ready in 25 minutes!");
    }
}