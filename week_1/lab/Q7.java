package week_1.lab;

import java.util.*;

public class Q7 {
    public static int[] trimBounds(String str) {
        int start = 0, end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ') start++;
        while (end >= start && str.charAt(end) == ' ') end--;
        return new int[]{start, end};
    }
    public static String substringManual(String str, int start, int end) {
        String res = "";
        for (int i = start; i <= end; i++) res += str.charAt(i);
        return res;
    }
    public static boolean compareStrings(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] bounds = trimBounds(s);
        String trimmed = substringManual(s, bounds[0], bounds[1]);
        String builtin = s.trim();
        System.out.println("Equal: " + compareStrings(trimmed, builtin));
        sc.close();
    }
}
