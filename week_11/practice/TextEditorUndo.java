package week_11.practice;

import java.util.*;

public class TextEditorUndo {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter command (TYPE <word>/UNDO/PRINT/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("TYPE")) {
                String word = sc.next();
                stack.push(word);
                System.out.println("Typed: " + word);
            } 
            else if (cmd.equalsIgnoreCase("UNDO")) {
                if (!stack.isEmpty()) {
                    System.out.println("Undo: " + stack.pop());
                } else {
                    System.out.println("Nothing to undo!");
                }
            } 
            else if (cmd.equalsIgnoreCase("PRINT")) {
                if (stack.isEmpty()) {
                    System.out.println("No text to display!");
                } else {
                    for (String s : stack)
                        System.out.print(s + " ");
                    System.out.println();
                }
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Exiting Editor...");
                break;
            } 
            else {
                System.out.println("Invalid command!");
            }
        }
    }
}
