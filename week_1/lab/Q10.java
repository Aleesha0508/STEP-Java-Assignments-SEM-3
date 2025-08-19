package week_1.lab;

import java.util.*;

public class Q10 {
    public static int[][] generateScores(int n) {
        Random r = new Random();
        int[][] scores = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                scores[i][j] = r.nextInt(41) + 60;
        return scores;
    }
    public static double[][] calculate(int[][] scores) {
        double[][] res = new double[scores.length][3];
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double perc = (total / 300.0) * 100;
            res[i][0] = total;
            res[i][1] = Math.round(avg * 100.0) / 100.0;
            res[i][2] = Math.round(perc * 100.0) / 100.0;
        }
        return res;
    }
    public static String grade(double perc) {
        if (perc >= 90) return "A";
        if (perc >= 80) return "B";
        if (perc >= 70) return "C";
        if (perc >= 60) return "D";
        return "F";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 5;
        int[][] scores = generateScores(n);
        double[][] calc = calculate(scores);
        for (int i = 0; i < n; i++) {
            System.out.println(scores[i][0] + "\t" + scores[i][1] + "\t" + scores[i][2] + "\t" +
                               calc[i][0] + "\t" + calc[i][1] + "\t" + calc[i][2] + "\t" +
                               grade(calc[i][2]));
        }
        sc.close();
    }
}
