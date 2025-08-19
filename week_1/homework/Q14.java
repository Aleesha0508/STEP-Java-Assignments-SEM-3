package week_1.homework;

import java.util.*;

public class Q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n, rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        if (temp == rev) System.out.println("Palindrome");
        else System.out.println("Not Palindrome");
        sc.close();
    }
}
