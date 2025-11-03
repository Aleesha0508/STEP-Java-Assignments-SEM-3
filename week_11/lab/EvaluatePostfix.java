package week_11.lab;

import java.util.*;

public class EvaluatePostfix {
    public static int evaluate(String expr) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expr.split(" ");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter postfix expression (e.g., 6 3 2 + *): ");
        String expr = sc.nextLine();

        int result = evaluate(expr);
        System.out.println("Result: " + result);
    }
}
