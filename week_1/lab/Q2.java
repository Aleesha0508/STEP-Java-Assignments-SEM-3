package week_1.lab;

import java.util.*;

public class Q2 {
    public static int getLength(String str) {
        int count = 0;
        try { while (true) { str.charAt(count); count++; } }
        catch (StringIndexOutOfBoundsException e) {}
        return count;
    }
    public static String[] manualSplit(String str) {
        int len = getLength(str);
        ArrayList<String> words = new ArrayList<>();
        String word = "";
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                if (!word.equals("")) { words.add(word); word = ""; }
            } else word += c;
        }
        if (!word.equals("")) words.add(word);
        return words.toArray(new String[0]);
    }
    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (!a[i].equals(b[i])) return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] manual = manualSplit(input);
        String[] builtin = input.split(" ");
        System.out.println("Equal: " + compareArrays(manual, builtin));
        sc.close();
    }
}
