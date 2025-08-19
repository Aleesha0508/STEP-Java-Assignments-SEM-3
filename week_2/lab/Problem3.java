package week_2.lab;

import java.util.*;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Iterations: ");
        int n = sc.nextInt();
        test("String", n);
        test("StringBuilder", n);
        test("StringBuffer", n);
        sc.close();
    }

    static void test(String type, int n) {
        long start = System.currentTimeMillis();
        String s = "";
        if (type.equals("String")) {
            for (int i = 0; i < n; i++) s += "x";
        } else if (type.equals("StringBuilder")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append("x");
            s = sb.toString();
        } else {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < n; i++) sb.append("x");
            s = sb.toString();
        }
        long end = System.currentTimeMillis();
        System.out.println(type + " | Time: " + (end - start) + "ms | Length: " + s.length());
    }
}
