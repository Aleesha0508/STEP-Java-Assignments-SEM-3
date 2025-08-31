package week_2.homework;

import java.util.Scanner;

public class TextCompressor {
    private static class Freq {
        char[] chars;
        int[] counts;
        int size;
    }

    private static Freq countFrequencies(String s) {
        char[] ch = new char[s.length()];
        int[] ct = new int[s.length()];
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = indexOf(ch, size, c);
            if (idx == -1) { ch[size] = c; ct[size] = 1; size++; }
            else ct[idx]++;
        }
        Freq f = new Freq();
        f.chars = new char[size];
        f.counts = new int[size];
        f.size = size;
        for (int i = 0; i < size; i++) { f.chars[i] = ch[i]; f.counts[i] = ct[i]; }
        return f;
    }

    private static int indexOf(char[] a, int size, char c) {
        for (int i = 0; i < size; i++) if (a[i] == c) return i;
        return -1;
    }

    private static void sortByFrequency(Freq f) {
        for (int i = 0; i < f.size - 1; i++) {
            int max = i;
            for (int j = i + 1; j < f.size; j++) if (f.counts[j] > f.counts[max]) max = j;
            swap(f.chars, i, max); swap(f.counts, i, max);
        }
    }

    private static void swap(char[] a, int i, int j) { char t = a[i]; a[i] = a[j]; a[j] = t; }
    private static void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }

    private static String[] buildCodes(Freq f) {
        String pool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()[]{}<>?/|;:,.-_+=~";
        if (f.size > pool.length()) throw new IllegalArgumentException("Too many unique characters for simple code pool.");
        String[] codes = new String[f.size];
        for (int i = 0; i < f.size; i++) codes[i] = "" + pool.charAt(i);
        return codes;
    }

    private static String compress(String text, Freq f, String[] codes) {
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int idx = indexOf(f.chars, f.size, c);
            sb.append(codes[idx]);
        }
        return sb.toString();
    }

    private static String decompress(String comp, Freq f, String[] codes) {
        StringBuilder sb = new StringBuilder(comp.length());
        for (int i = 0; i < comp.length(); i++) {
            char token = comp.charAt(i);
            int idx = indexOfCode(codes, f.size, token);
            if (idx == -1) throw new IllegalStateException("Unknown code token: " + token);
            sb.append(f.chars[idx]);
        }
        return sb.toString();
    }

    private static int indexOfCode(String[] codes, int size, char token) {
        for (int i = 0; i < size; i++) if (codes[i].length() == 1 && codes[i].charAt(0) == token) return i;
        return -1;
    }

    private static void displayAnalysis(String original, Freq f, String[] codes, String compressed, String decompressed) {
        System.out.println("Character Frequency:");
        System.out.println("--------------------");
        for (int i = 0; i < f.size; i++) {
            String ch = f.chars[i] == '\n' ? "\\n" : (f.chars[i] == '\t' ? "\\t" : String.valueOf(f.chars[i]));
            System.out.println(String.format("%-4s : %d", ch, f.counts[i]));
        }
        System.out.println("\nCompression Mapping:");
        System.out.println("--------------------");
        for (int i = 0; i < f.size; i++) {
            String ch = f.chars[i] == '\n' ? "\\n" : (f.chars[i] == '\t' ? "\\t" : String.valueOf(f.chars[i]));
            System.out.println(String.format("%-4s -> %s", ch, codes[i]));
        }
        int origSize = original.length();
        int compSize = compressed.length();
        double efficiency = origSize == 0 ? 0 : (1.0 - (double) compSize / origSize) * 100.0;
        System.out.println("\nOriginal:   " + original);
        System.out.println("Compressed: " + compressed);
        System.out.println("Decompressed matches: " + original.equals(decompressed));
        System.out.println(String.format("Compression Efficiency: %.2f%%", efficiency));
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String text = sc.nextLine();
            Freq f = countFrequencies(text);
            sortByFrequency(f);
            String[] codes = buildCodes(f);
            String compressed = compress(text, f, codes);
            String decompressed = decompress(compressed, f, codes);
            displayAnalysis(text, f, codes, compressed, decompressed);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
