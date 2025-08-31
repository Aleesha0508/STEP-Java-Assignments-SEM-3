package week_2.homework;

import java.util.Scanner;

public class SpellCheckerApp {
    private static String[] readDictionary(Scanner sc) {
        System.out.print("Enter dictionary size: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        String[] dict = new String[n];
        for (int i = 0; i < n; i++) {
            dict[i] = sc.nextLine().trim();
        }
        return dict;
    }

    private static String[] splitSentenceManual(String s) {
        String[] tmp = new String[s.length() + 1];
        int count = 0, i = 0;
        while (i < s.length()) {
            while (i < s.length() && !isWordChar(s.charAt(i))) i++;
            int start = i;
            while (i < s.length() && isWordChar(s.charAt(i))) i++;
            if (start < i) tmp[count++] = s.substring(start, i);
        }
        String[] words = new String[count];
        for (i = 0; i < count; i++) words[i] = tmp[i];
        return words;
    }

    private static boolean isWordChar(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    private static int stringDistance(String a, String b) {
        int la = a.length(), lb = b.length();
        int min = Math.min(la, lb), diff = Math.abs(la - lb), mism = 0;
        for (int i = 0; i < min; i++) if (a.charAt(i) != b.charAt(i)) mism++;
        return mism + diff;
    }

    private static String findClosest(String word, String[] dict) {
        int best = Integer.MAX_VALUE; String bestWord = word;
        for (String d : dict) {
            int dist = stringDistance(word.toLowerCase(), d.toLowerCase());
            if (dist < best) { best = dist; bestWord = d; }
        }
        return stringDistance(word.toLowerCase(), bestWord.toLowerCase()) <= 2 ? bestWord : word;
    }

    private static void displayResults(String[] words, String[] dict) {
        String header = String.format("%-15s | %-18s | %-8s | %-12s", "Word", "Suggestion", "Distance", "Status");
        String line = repeat("-", header.length());
        System.out.println(line);
        System.out.println(header);
        System.out.println(line);
        for (String w : words) {
            String sug = findClosest(w, dict);
            int dist = stringDistance(w.toLowerCase(), sug.toLowerCase());
            boolean correct = containsIgnoreCase(dict, w);
            String status = correct ? "Correct" : (sug.equals(w) ? "Unknown" : "Misspelled");
            System.out.println(String.format("%-15s | %-18s | %-8d | %-12s", w, sug, correct ? 0 : dist, status));
        }
        System.out.println(line);
    }

    private static boolean containsIgnoreCase(String[] arr, String t) {
        for (String s : arr) if (s.equalsIgnoreCase(t)) return true;
        return false;
    }

    private static String repeat(String s, int n) {
        StringBuilder b = new StringBuilder(n);
        for (int i = 0; i < n; i++) b.append(s);
        return b.toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter sentence to check:");
            String sentence = sc.nextLine();
            System.out.println("Enter dictionary words (one per line):");
            String[] dict = readDictionary(sc);
            String[] words = splitSentenceManual(sentence);
            displayResults(words, dict);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
