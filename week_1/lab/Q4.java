package week_1.lab;

import java.util.*;

public class Q4 {
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
    public static int[] findMinMax(String[] words) {
        int min = getLength(words[0]), max = getLength(words[0]);
        for (String w : words) {
            int l = getLength(w);
            if (l < min) min = l;
            if (l > max) max = l;
        }
        return new int[]{min, max};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = manualSplit(input);
        int[] res = findMinMax(words);
        System.out.println("Shortest length: " + res[0]);
        System.out.println("Longest length: " + res[1]);
        sc.close();
    }
}
