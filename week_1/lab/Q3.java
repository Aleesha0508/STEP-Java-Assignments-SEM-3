package week_1.lab;

import java.util.*;

public class Q3 {
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
    public static String[][] wordWithLength(String[] words) {
        String[][] res = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            res[i][0] = words[i];
            res[i][1] = String.valueOf(getLength(words[i]));
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = manualSplit(input);
        String[][] result = wordWithLength(words);
        for (String[] row : result)
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        sc.close();
    }
}
