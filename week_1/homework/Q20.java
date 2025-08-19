package week_1.homework;

import java.util.*;

public class Q20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean prime = n > 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }
        if (prime) System.out.println("Prime");
        else System.out.println("Not Prime");
        sc.close();
    }
}
