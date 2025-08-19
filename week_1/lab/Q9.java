package week_1.lab;

import java.util.*;

public class Q9 {
    public static String computerChoice() {
        int c = (int)(Math.random() * 3);
        if (c == 0) return "rock";
        if (c == 1) return "paper";
        return "scissors";
    }
    public static int winner(String user, String comp) {
        if (user.equals(comp)) return 0;
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("scissors") && comp.equals("paper")) ||
            (user.equals("paper") && comp.equals("rock"))) return 1;
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int userWins = 0, compWins = 0;
        for (int i = 0; i < n; i++) {
            String user = sc.next();
            String comp = computerChoice();
            int res = winner(user, comp);
            if (res == 1) userWins++;
            else if (res == -1) compWins++;
            System.out.println("User: " + user + " Computer: " + comp);
        }
        System.out.println("User Wins: " + userWins);
        System.out.println("Computer Wins: " + compWins);
        System.out.println("User %: " + (userWins * 100.0 / n));
        System.out.println("Computer %: " + (compWins * 100.0 / n));
        sc.close();
    }
}
