package week_2.lab;

import java.util.*;

public class Problem6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter width: ");
        int width = sc.nextInt();
        List<String> words = splitWords(text);
        System.out.println("Justified:\n" + justify(words, width));
        System.out.println("Centered:\n" + center(text, width));
        sc.close();
    }

    static List<String> splitWords(String text) {
        List<String> words = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                if (i > start) words.add(text.substring(start, i));
                start = i + 1;
            }
        }
        if (start < text.length()) words.add(text.substring(start));
        return words;
    }

    static String justify(List<String> words, int width) {
        StringBuilder res = new StringBuilder();
        List<String> line = new ArrayList<>();
        int len = 0;
        for (String w : words) {
            if (len + w.length() + line.size() > width) {
                int spaces = width - len;
                for (int i = 0; i < line.size(); i++) {
                    res.append(line.get(i));
                    if (i < line.size() - 1) {
                        int extra = spaces / (line.size() - 1) + (i < spaces % (line.size() - 1) ? 1 : 0);
                        for (int j = 0; j < extra; j++) res.append(" ");
                    }
                }
                res.append("\n");
                line.clear();
                len = 0;
            }
            line.add(w);
            len += w.length();
        }
        for (int i = 0; i < line.size(); i++) {
            res.append(line.get(i));
            if (i < line.size() - 1) res.append(" ");
        }
        res.append("\n");
        return res.toString();
    }

    static String center(String text, int width) {
        StringBuilder res = new StringBuilder();
        String[] lines = text.split("\n");
        for (String line : lines) {
            int pad = (width - line.length()) / 2;
            for (int i = 0; i < pad; i++) res.append(" ");
            res.append(line).append("\n");
        }
        return res.toString();
    }
}
