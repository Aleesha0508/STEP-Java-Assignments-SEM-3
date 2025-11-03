package week_11.practice;

import java.util.*;

public class BrowserNavigation {
    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        String current = "Home";

        while (true) {
            System.out.print("Command (VISIT/BACK/FORWARD/PRINT/EXIT): ");
            String cmd = sc.next();

            if (cmd.equalsIgnoreCase("VISIT")) {
                String url = sc.next();
                backStack.push(current);
                current = url;
                forwardStack.clear();
                System.out.println("Visited: " + current);
            } 
            else if (cmd.equalsIgnoreCase("BACK")) {
                if (!backStack.isEmpty()) {
                    forwardStack.push(current);
                    current = backStack.pop();
                    System.out.println("Moved Back to: " + current);
                } else {
                    System.out.println("No pages in back history!");
                }
            } 
            else if (cmd.equalsIgnoreCase("FORWARD")) {
                if (!forwardStack.isEmpty()) {
                    backStack.push(current);
                    current = forwardStack.pop();
                    System.out.println("Moved Forward to: " + current);
                } else {
                    System.out.println("No pages in forward history!");
                }
            } 
            else if (cmd.equalsIgnoreCase("PRINT")) {
                System.out.println("Current Page: " + current);
            } 
            else if (cmd.equalsIgnoreCase("EXIT")) {
                System.out.println("Closing Browser Simulation...");
                break;
            } 
            else {
                System.out.println("Invalid Command!");
            }
        }
    }
}
