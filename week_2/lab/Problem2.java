package week_2.lab;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.println("Uppercase: " + toUpper(text));
        System.out.println("Lowercase: " + toLower(text));
        System.out.println("Title Case: " + toTitle(text));
        sc.close();
    }

    static String toUpper(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            sb.append((c >= 'a' && c <= 'z') ? (char) (c - 32) : c);
        return sb.toString();
    }

    static String toLower(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            sb.append((c >= 'A' && c <= 'Z') ? (char) (c + 32) : c);
        return sb.toString();
    }

    static String toTitle(String s) {
        String lower = toLower(s);
        StringBuilder sb = new StringBuilder();
        boolean cap = true;
        for (char c : lower.toCharArray()) {
            if (Character.isWhitespace(c)) {
                sb.append(c);
                cap = true;
            } else if (cap && c >= 'a' && c <= 'z') {
                sb.append((char) (c - 32));
                cap = false;
            } else {
                sb.append(c);
                cap = false;
            }
        }
        return sb.toString();
    }
}
