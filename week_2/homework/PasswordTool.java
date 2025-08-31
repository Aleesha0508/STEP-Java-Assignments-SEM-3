package week_2.homework;

import java.util.Random;
import java.util.Scanner;

public class PasswordTool {
    private static class Analysis {
        String password;
        int length, upper, lower, digits, special, score;
        String strength;
    }

    private static Analysis analyze(String p) {
        Analysis a = new Analysis();
        a.password = p;
        a.length = p.length();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c >= 65 && c <= 90) a.upper++;
            else if (c >= 97 && c <= 122) a.lower++;
            else if (c >= 48 && c <= 57) a.digits++;
            else if (c >= 32 && c <= 126) a.special++;
        }
        int types = 0;
        if (a.upper > 0) types++;
        if (a.lower > 0) types++;
        if (a.digits > 0) types++;
        if (a.special > 0) types++;
        int score = 0;
        if (a.length > 8) score += (a.length - 8) * 2;
        score += types * 10;
        if (hasCommonPatterns(p)) score -= 15;
        if (hasSequential(p)) score -= 10;
        if (a.length < 6) score -= 10;
        a.score = Math.max(0, score);
        a.strength = a.score >= 51 ? "Strong" : (a.score >= 21 ? "Medium" : "Weak");
        return a;
    }

    private static boolean hasCommonPatterns(String p) {
        String s = p.toLowerCase();
        String[] bad = {"123", "1234", "password", "qwerty", "admin", "letmein", "iloveyou", "abc", "abcd"};
        for (String b : bad) if (s.indexOf(b) >= 0) return true;
        return false;
    }

    private static boolean hasSequential(String p) {
        String s = p.toLowerCase();
        for (int i = 0; i + 2 < s.length(); i++) {
            char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2);
            if ((b == a + 1 && c == b + 1) || (b == a - 1 && c == b - 1)) return true;
        }
        return false;
    }

    private static String generateStrong(int length) {
        if (length < 8) length = 12;
        String upp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String low = "abcdefghijklmnopqrstuvwxyz";
        String dig = "0123456789";
        String spe = "!@#$%^&*()-_=+[]{};:,.?/\\";
        String all = upp + low + dig + spe;
        Random r = new Random();
        StringBuilder sb = new StringBuilder(length);
        sb.append(upp.charAt(r.nextInt(upp.length())));
        sb.append(low.charAt(r.nextInt(low.length())));
        sb.append(dig.charAt(r.nextInt(dig.length())));
        sb.append(spe.charAt(r.nextInt(spe.length())));
        while (sb.length() < length) sb.append(all.charAt(r.nextInt(all.length())));
        return shuffle(sb, r).toString();
    }

    private static StringBuilder shuffle(StringBuilder sb, Random r) {
        for (int i = sb.length() - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            char ci = sb.charAt(i), cj = sb.charAt(j);
            sb.setCharAt(i, cj); sb.setCharAt(j, ci);
        }
        return sb;
    }

    private static void display(Analysis[] arr) {
        String header = String.format("%-20s | %6s | %6s | %6s | %6s | %7s | %6s | %-6s", "Password", "Len", "Upper", "Lower", "Digits", "Special", "Score", "Level");
        String line = repeat("-", header.length());
        System.out.println(line);
        System.out.println(header);
        System.out.println(line);
        for (Analysis a : arr) {
            System.out.println(String.format("%-20s | %6d | %6d | %6d | %6d | %7d | %6d | %-6s",
                    a.password, a.length, a.upper, a.lower, a.digits, a.special, a.score, a.strength));
        }
        System.out.println(line);
    }

    private static String repeat(String s, int n) {
        StringBuilder b = new StringBuilder(n);
        for (int i = 0; i < n; i++) b.append(s);
        return b.toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("How many passwords to analyze? ");
            int n = Integer.parseInt(sc.nextLine().trim());
            Analysis[] results = new Analysis[n];
            for (int i = 0; i < n; i++) results[i] = analyze(sc.nextLine());
            display(results);
            System.out.print("Generate how many strong passwords? ");
            int g = Integer.parseInt(sc.nextLine().trim());
            System.out.print("Desired length (>=8): ");
            int len = Integer.parseInt(sc.nextLine().trim());
            for (int i = 0; i < g; i++) {
                String pw = generateStrong(len);
                System.out.println(pw);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
