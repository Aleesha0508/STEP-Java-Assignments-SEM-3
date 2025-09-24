package week_7.practice;

public class PizzaPlace extends Restaurant {
    public PizzaPlace(String name) {
        super(name);
    }
    @Override
    public void prepareFood() {
        System.out.println(name + " is making delicious pizza with fresh toppings!");
    }
    @Override
    public void estimateTime() {
        System.out.println("Pizza ready in 20 minutes!");
    }
}