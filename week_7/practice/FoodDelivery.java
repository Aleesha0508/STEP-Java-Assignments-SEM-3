package week_7.practice;

public class FoodDelivery {
    public static void main(String[] args) {
        Restaurant r = new PizzaPlace("Mario's Pizza");
        r.prepareFood();
        r.estimateTime();
        r = new SushiBar("Tokyo Sushi");
        r.prepareFood();
        r.estimateTime();
    }
}
