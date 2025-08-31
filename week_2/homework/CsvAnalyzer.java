package week_2.homework;

import java.util.Scanner;

public class CsvAnalyzer {
    private static String[][] parseCSV(String input) {
        String[][] tmp = new String[1024][128];
        int row = 0, col = 0, i = 0;
        while (i < input.length()) {
            StringBuilder field = new StringBuilder();
            boolean quoted = false;
            if (i < input.length() && input.charAt(i) == '"') { quoted = true; i++; }
            while (i < input.length()) {
                char c = input.charAt(i);
                if (quoted) {
                    if (c == '"') {
                        if (i + 1 < input.length() && input.charAt(i + 1) == '"') { field.append('"'); i += 2; }
                        else { i++; break; }
                    } else { field.append(c); i++; }
                } else {
                    if (c == ',' || c == '\n' || c == '\r') break;
                    field.append(c); i++;
                }
            }
            String val = field.toString();
            tmp[row][col++] = val;
            if (i < input.length()) {
                char c = input.charAt(i);
                if (c == ',') { i++; }
                else if (c == '\r') { i++; if (i < input.length() && input.charAt(i) == '\n') i++; row++; col = 0; }
                else if (c == '\n') { i++; row++; col = 0; }
            }
        }
        if (col != 0) { row++; }
        int cols = 0; for (int c = 0; c < tmp[0].length; c++) if (tmp[0][c] != null) cols++; 
        String[][] out = new String[row][cols];
        for (int r = 0; r < row; r++) for (int c = 0; c < cols; c++) out[r][c] = tmp[r][c] == null ? "" : tmp[r][c];
        return out;
    }

    private static String trimSpaces(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j && s.charAt(i) == ' ') i++;
        while (j >= i && s.charAt(j) == ' ') j--;
        return s.substring(i, j + 1);
    }

    private static boolean isNumeric(String s) {
        if (s == null || s.length() == 0) return false;
        int i = 0, dots = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') i++;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '.') { dots++; if (dots > 1) return false; }
            else if (!(c >= '0' && c <= '9')) return false;
        }
        return true;
    }

    private static String[][] clean(String[][] data) {
        for (int r = 0; r < data.length; r++)
            for (int c = 0; c < data[r].length; c++)
                data[r][c] = trimSpaces(data[r][c]);
        return data;
    }

    private static void analyze(String[][] data) {
        int rows = data.length, cols = data[0].length;
        boolean[] numeric = new boolean[cols];
        for (int c = 0; c < cols; c++) {
            boolean ok = true;
            for (int r = 1; r < rows; r++) if (!isNumeric(data[r][c])) { ok = false; break; }
            numeric[c] = ok;
        }
        double[] min = new double[cols], max = new double[cols], sum = new double[cols];
        int[] count = new int[cols], missing = new int[cols];
        for (int c = 0; c < cols; c++) {
            if (numeric[c]) {
                for (int r = 1; r < rows; r++) {
                    String v = data[r][c];
                    if (v.length() == 0) { missing[c]++; continue; }
                    double d = Double.parseDouble(v);
                    if (count[c] == 0) { min[c] = max[c] = d; }
                    else { if (d < min[c]) min[c] = d; if (d > max[c]) max[c] = d; }
                    sum[c] += d; count[c]++;
                }
            } else {
                for (int r = 1; r < rows; r++) if (data[r][c].length() == 0) missing[c]++;
            }
        }
        displayTable(data);
        System.out.println("\nColumn Statistics:");
        for (int c = 0; c < cols; c++) {
            if (numeric[c] && count[c] > 0) {
                double avg = sum[c] / count[c];
                System.out.println(String.format("Col %d (numeric): min=%.2f max=%.2f avg=%.2f missing=%d", c+1, min[c], max[c], avg, missing[c]));
            } else {
                System.out.println(String.format("Col %d (text): missing=%d", c+1, missing[c]));
            }
        }
        int totalCells = (rows - 1) * cols, totalMissing = 0;
        for (int c = 0; c < cols; c++) totalMissing += missing[c];
        double completeness = totalCells == 0 ? 100 : (1.0 - (double) totalMissing / totalCells) * 100.0;
        System.out.println(String.format("\nRecords: %d, Columns: %d, Completeness: %.2f%%", rows - 1, cols, completeness));
    }

    private static void displayTable(String[][] data) {
        int rows = data.length, cols = data[0].length;
        int[] width = new int[cols];
        for (int c = 0; c < cols; c++) {
            int w = 0;
            for (int r = 0; r < rows; r++) if (data[r][c].length() > w) w = data[r][c].length();
            width[c] = Math.max(w, 6);
        }
        String sep = "+";
        for (int c = 0; c < cols; c++) sep += repeat("-", width[c] + 2) + "+";
        System.out.println(sep);
        for (int r = 0; r < rows; r++) {
            StringBuilder line = new StringBuilder("|");
            for (int c = 0; c < cols; c++) {
                String cell = data[r][c];
                line.append(" ").append(pad(cell, width[c])).append(" |");
            }
            System.out.println(line);
            System.out.println(sep);
        }
    }

    private static String pad(String s, int w) {
        if (s.length() >= w) return s;
        StringBuilder b = new StringBuilder(w);
        b.append(s);
        while (b.length() < w) b.append(' ');
        return b.toString();
    }

    private static String repeat(String s, int n) {
        StringBuilder b = new StringBuilder(n);
        for (int i = 0; i < n; i++) b.append(s);
        return b.toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            StringBuilder input = new StringBuilder();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equals("__END__")) break;
                input.append(line).append('\n');
            }
            String[][] parsed = parseCSV(input.toString());
            analyze(clean(parsed));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
