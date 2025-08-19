package week_1.lab;

import java.util.*;

public class Q8 {
    public static int[] randomAges(int n) {
        Random r = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) ages[i] = r.nextInt(90) + 10;
        return ages;
    }
    public static String[][] canVote(int[] ages) {
        String[][] res = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            res[i][0] = String.valueOf(ages[i]);
            res[i][1] = (ages[i] >= 18) ? "true" : "false";
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = randomAges(10);
        String[][] res = canVote(ages);
        for (String[] row : res) System.out.println(row[0] + "\t" + row[1]);
        sc.close();
    }
}
