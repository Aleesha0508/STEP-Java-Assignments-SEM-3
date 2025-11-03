package week_11.homework;

import java.util.*;

public class InfixToPostfix {
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (Character.isLetterOrDigit(ch))
                result += ch;
            else if (ch == '(')
                stack.push(ch);
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                    result += stack.pop();
                stack.push(ch);
            }
        }

        while (!stack.isEmpty())
            result += stack.pop();

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter infix expression: ");
        String exp = sc.nextLine();
        System.out.println("Postfix expression: " + infixToPostfix(exp));
    }
}
