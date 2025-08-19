package week_1.lab;

import java.util.*;

public class Q6 {
    public static String charType(char c) {
        if (c >= 'A' && c <= 'Z') c = (char)(c + 32);
        if (c >= 'a' && c <= 'z') {
            if ("aeiou".indexOf(c) >= 0) return "Vowel";
            else return "Consonant";
        }
        return "Not a Letter";
    }
    public static String[][] classify(String s) {
        String[][] res = new String[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            res[i][0] = String.valueOf(s.charAt(i));
            res[i][1] = charType(s.charAt(i));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[][] res = classify(s);
        for (String[] row : res) System.out.println(row[0] + "\t" + row[1]);
        sc.close();
    }
}
