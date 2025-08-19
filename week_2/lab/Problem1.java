package week_2.lab;

import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter substring to find: ");
        String find = sc.nextLine();
        System.out.print("Enter replacement: ");
        String replace = sc.nextLine();

        String manual = manualReplace(text, find, replace);
        String builtin = text.replace(find, replace);
        System.out.println("Manual Replace: " + manual);
        System.out.println("Built-in Replace: " + builtin);
        System.out.println("Match? " + manual.equals(builtin));
        sc.close();
    }

    static String manualReplace(String text, String find, String replace) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < text.length()) {
            int pos = text.indexOf(find, i);
            if (pos < 0) {
                result.append(text.substring(i));
                break;
            }
            result.append(text.substring(i, pos)).append(replace);
            i = pos + find.length();
        }
        return result.toString();
    }
}
