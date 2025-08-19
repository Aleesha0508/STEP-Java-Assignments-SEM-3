package week_2.lab;

import java.util.*;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter emails (comma separated):");
        String[] emails = sc.nextLine().split(",");
        for (String e : emails) {
            e = e.trim();
            boolean valid = validate(e);
            if (valid) {
                String user = e.substring(0, e.indexOf('@'));
                String domain = e.substring(e.indexOf('@') + 1);
                String dname = domain.contains(".") ? domain.substring(0, domain.indexOf('.')) : domain;
                String ext = domain.contains(".") ? domain.substring(domain.lastIndexOf('.') + 1) : "";
                System.out.println(e + " | " + user + " | " + domain + " | " + dname + " | " + ext + " | Valid");
            } else {
                System.out.println(e + " | Invalid");
            }
        }
        sc.close();
    }

    static boolean validate(String email) {
        int at = email.indexOf('@');
        int lastAt = email.lastIndexOf('@');
        if (at <= 0 || at != lastAt) return false;
        int dot = email.indexOf('.', at);
        if (dot < 0 || dot == email.length() - 1) return false;
        return true;
    }
}
