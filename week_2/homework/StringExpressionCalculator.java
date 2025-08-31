package week_2.homework;

import java.util.Scanner;

public class StringExpressionCalculator {
    private static boolean isDigit(char c) { return c >= '0' && c <= '9'; }
    private static boolean isOp(char c) { return c=='+'||c=='-'||c=='*'||c=='/'; }
    private static boolean isValidChar(char c) {
        return isDigit(c) || isOp(c) || c==' ' || c=='(' || c==')';
    }

    private static boolean validate(String expr) {
        int bal = 0; char prev = 0; boolean prevIsOp = true;
        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);
            if (!isValidChar(c)) return false;
            if (c == '(') { bal++; prevIsOp = true; }
            else if (c == ')') { if (bal == 0 || isOp(prev)) return false; bal--; prevIsOp = false; }
            else if (isOp(c)) { if (prevIsOp) return false; prevIsOp = true; }
            else if (isDigit(c)) { prevIsOp = false; }
            if (c != ' ') prev = c;
        }
        return bal == 0 && !isOp(prev);
    }

    private static int evalNoParens(String s, StringBuilder steps) {
        int cap = s.length()/2 + 2, nCount = 0, oCount = 0;
        long[] nums = new long[cap];
        char[] ops = new char[cap];
        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') i++;
            int start = i;
            while (i < s.length() && isDigit(s.charAt(i))) i++;
            if (start == i) throw new IllegalArgumentException("Invalid number in: " + s);
            nums[nCount++] = Long.parseLong(s.substring(start, i));
            while (i < s.length() && s.charAt(i) == ' ') i++;
            if (i < s.length()) { ops[oCount++] = s.charAt(i); i++; }
        }
        for (int k = 0; k < oCount; k++) {
            if (ops[k] == '*' || ops[k] == '/') {
                long a = nums[k], b = nums[k+1];
                long r = ops[k] == '*' ? a * b : a / b;
                nums[k] = r;
                for (int m = k+1; m < nCount-1; m++) nums[m] = nums[m+1];
                for (int m = k; m < oCount-1; m++) ops[m] = ops[m+1];
                nCount--; oCount--; k--;
                steps.append("=> ").append(r).append(" (mul/div)\n");
            }
        }
        long res = nums[0];
        for (int k = 0; k < oCount; k++) {
            res = ops[k] == '+' ? res + nums[k+1] : res - nums[k+1];
            steps.append("=> ").append(res).append(" (add/sub)\n");
        }
        return (int) res;
    }

    private static int eval(String expr, StringBuilder steps) {
        String s = expr;
        while (s.indexOf('(') >= 0) {
            int r = s.indexOf(')');
            if (r < 0) throw new IllegalArgumentException("Unmatched parentheses");
            int l = s.lastIndexOf('(', r);
            String inner = s.substring(l + 1, r);
            int val = evalNoParens(inner, steps);
            s = s.substring(0, l) + val + s.substring(r + 1);
            steps.append("Paren ").append(inner).append(" = ").append(val).append("\n");
        }
        return evalNoParens(s, steps);
    }

    private static void show(String expr, int result, String steps) {
        System.out.println("Expression: " + expr);
        System.out.println("Steps:");
        System.out.print(steps);
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = Integer.parseInt(sc.nextLine().trim());
            for (int k = 0; k < t; k++) {
                String expr = sc.nextLine();
                if (!validate(expr)) { System.out.println("Invalid expression: " + expr); continue; }
                StringBuilder steps = new StringBuilder();
                int res = eval(expr, steps);
                show(expr, res, steps.toString());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
