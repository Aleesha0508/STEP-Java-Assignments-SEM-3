package week_2.homework;

import java.time.LocalDate;
import java.util.Scanner;

public class FileOrganizer {
    private static class FileInfo {
        String originalName;
        String baseName;
        String extension;
        String category;
        String newName;
        String contentHint;
        String subcategory;
        int priority;
        boolean valid;
    }

    private static FileInfo parseFile(String name, String contentHint) {
        FileInfo f = new FileInfo();
        f.originalName = name;
        f.contentHint = contentHint == null ? "" : contentHint;
        int dot = name.lastIndexOf('.');
        if (dot <= 0 || dot == name.length() - 1) { f.valid = false; f.baseName = name; f.extension = ""; }
        else { f.baseName = name.substring(0, dot); f.extension = name.substring(dot).toLowerCase(); f.valid = isValidName(f.baseName); }
        return f;
    }

    private static boolean isValidName(String s) {
        if (s.length() == 0) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='/'||c=='\\'||c==':'||c=='*'||c=='?'||c=='"'||c=='<'||c=='>'||c=='|') return false;
        }
        return true;
    }

    private static String categoryFor(String ext) {
        if (ext.equals(".txt") || ext.equals(".doc") || ext.equals(".docx") || ext.equals(".pdf")) return "Documents";
        if (ext.equals(".jpg") || ext.equals(".jpeg") || ext.equals(".png") || ext.equals(".gif")) return "Images";
        if (ext.equals(".mp3") || ext.equals(".wav")) return "Audio";
        if (ext.equals(".mp4") || ext.equals(".mkv")) return "Video";
        if (ext.equals(".csv") || ext.equals(".xlsx")) return "Data";
        if (ext.equals(".java") || ext.equals(".py") || ext.equals(".c") || ext.equals(".cpp")) return "Code";
        return "Unknown";
    }

    private static String buildNewName(FileInfo f, LocalDate date, int index) {
        String dateStr = date.toString().replace("-", "");
        String base = f.category + "_" + dateStr + "_" + sanitize(f.baseName);
        String candidate = base + (index > 0 ? "_" + index : "") + f.extension;
        return candidate;
    }

    private static String sanitize(String s) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c==' ' || c=='-' || c=='_' || (c>='0'&&c<='9') || (c>='A'&&c<='Z') || (c>='a'&&c<='z')) b.append(c==' ' ? '_' : c);
        }
        if (b.length() == 0) b.append("file");
        return b.toString();
    }

    private static void analyzeContent(FileInfo f) {
        String t = f.contentHint.toLowerCase();
        if (f.category.equals("Documents") || f.category.equals("Code") || f.extension.equals(".txt")) {
            if (containsWord(t, "resume") || containsWord(t, "cv")) f.subcategory = "Resume";
            else if (containsWord(t, "report")) f.subcategory = "Report";
            else if (containsWord(t, "invoice")) f.subcategory = "Invoice";
            else if (containsWord(t, "project") || containsWord(t, "assignment")) f.subcategory = "Project";
            else if (containsWord(t, "code") || containsWord(t, "class") || containsWord(t, "function")) f.subcategory = "Code";
            else f.subcategory = "General";
        } else if (f.category.equals("Images")) {
            if (containsWord(t, "selfie") || containsWord(t, "portrait")) f.subcategory = "Portrait";
            else if (containsWord(t, "screenshot")) f.subcategory = "Screenshot";
            else f.subcategory = "Photo";
        } else f.subcategory = "General";
        f.priority = priorityFromName(f);
    }

    private static boolean containsWord(String text, String word) {
        int i = text.indexOf(word);
        if (i < 0) return false;
        return true;
    }

    private static int priorityFromName(FileInfo f) {
        String n = f.baseName.toLowerCase();
        int p = 0;
        if (n.indexOf("final") >= 0) p += 3;
        if (n.indexOf("draft") >= 0) p += 1;
        if (n.indexOf("urgent") >= 0) p += 5;
        if (n.indexOf("v2") >= 0 || n.indexOf("v3") >= 0) p += 2;
        if (f.subcategory.equals("Resume") || f.subcategory.equals("Invoice")) p += 4;
        return p;
    }

    private static void displayReport(FileInfo[] files) {
        String header = String.format("%-25s | %-10s | %-12s | %-18s | %-10s | %-7s", "Original Name", "Category", "Subcategory", "New Name", "Valid", "Prio");
        String line = repeat("-", header.length());
        System.out.println(line);
        System.out.println(header);
        System.out.println(line);
        int docs=0, imgs=0, aud=0, vid=0, data=0, code=0, unk=0, invalid=0;
        for (FileInfo f : files) {
            System.out.println(String.format("%-25s | %-10s | %-12s | %-18s | %-10s | %-7d",
                    f.originalName, f.category, f.subcategory, f.newName, f.valid ? "OK" : "INVALID", f.priority));
            switch (f.category) {
                case "Documents": docs++; break;
                case "Images": imgs++; break;
                case "Audio": aud++; break;
                case "Video": vid++; break;
                case "Data": data++; break;
                case "Code": code++; break;
                default: unk++; break;
            }
            if (!f.valid) invalid++;
        }
        System.out.println(line);
        System.out.println("Counts -> Documents: " + docs + ", Images: " + imgs + ", Audio: " + aud + ", Video: " + vid + ", Data: " + data + ", Code: " + code + ", Unknown: " + unk);
        System.out.println("Invalid names: " + invalid);
    }

    private static void showBatchCommands(FileInfo[] files) {
        System.out.println("\nBatch Rename Commands (simulation):");
        for (FileInfo f : files) {
            if (f.valid && !f.category.equals("Unknown")) {
                System.out.println("rename \"" + f.originalName + "\" \"" + f.newName + "\"");
            }
        }
    }

    private static String repeat(String s, int n) {
        StringBuilder b = new StringBuilder(n);
        for (int i = 0; i < n; i++) b.append(s);
        return b.toString();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("How many files? ");
            int n = Integer.parseInt(sc.nextLine().trim());
            FileInfo[] files = new FileInfo[n];
            for (int i = 0; i < n; i++) {
                String name = sc.nextLine().trim();
                String hint = sc.hasNextLine() ? sc.nextLine() : "";
                files[i] = parseFile(name, hint);
            }
            LocalDate today = LocalDate.now();
            for (int i = 0; i < n; i++) {
                FileInfo f = files[i];
                f.category = categoryFor(f.extension);
                analyzeContent(f);
                int idx = 0;
                f.newName = buildNewName(f, today, idx);
            }
            displayReport(files);
            showBatchCommands(files);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
