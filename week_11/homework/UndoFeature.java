package week_11.homework;

import java.util.*;

public class UndoFeature {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command (TYPE <word>/UNDO/SHOW/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("TYPE")) {
                String word = sc.next();
                stack.push(word);
            } else if (cmd.equalsIgnoreCase("UNDO")) {
                if (!stack.isEmpty())
                    System.out.println("Undo: " + stack.pop());
                else
                    System.out.println("Nothing to undo!");
            } else if (cmd.equalsIgnoreCase("SHOW")) {
                System.out.println("Text: " + String.join(" ", stack));
            } else if (cmd.equalsIgnoreCase("EXIT")) {
                break;
            }
        }
    }
}
