package week_1.lab;

import java.util.*;

public class Q1 {
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int manualLength = getLength(input);
        int builtInLength = input.length();
        System.out.println("Manual length: " + manualLength);
        System.out.println("Built-in length: " + builtInLength);
        sc.close();
    }
}
