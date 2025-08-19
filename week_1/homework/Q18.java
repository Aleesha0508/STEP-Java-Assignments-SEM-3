package week_1.homework;

import java.util.*;

public class Q18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            if (val < min) min = val;
        }
        System.out.println(min);
        sc.close();
    }
}
