package week_1.lab;

import java.util.*;

public class Q5 {
    public static String charType(char c) {
        if (c >= 'A' && c <= 'Z') c = (char)(c + 32);
        if (c >= 'a' && c <= 'z') {
            if ("aeiou".indexOf(c) >= 0) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }
    public static int[] countVC(String str) {
        int v = 0, c = 0;
        for (int i = 0; i < str.length(); i++) {
            String t = charType(str.charAt(i));
            if (t.equals("Vowel")) v++;
            else if (t.equals("Consonant")) c++;
        }
        return new int[]{v, c};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] res = countVC(s);
        System.out.println("Vowels: " + res[0]);
        System.out.println("Consonants: " + res[1]);
        sc.close();
    }
}
