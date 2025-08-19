package week_1.homework;

import java.util.*;

public class Q19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n, sum = 0;
        int digits = String.valueOf(n).length();
        while (n > 0) {
            int d = n % 10;
            sum += Math.pow(d, digits);
            n /= 10;
        }
        if (sum == temp) System.out.println("Armstrong");
        else System.out.println("Not Armstrong");
        sc.close();
    }
}
