package week_7.homework;

public class OnlineLearning {
    public static void main(String[] args) {
        Course[] courses = {
            new VideoCourse("Java Basics", "Alice", 80, 120),
            new InteractiveCourse("Python Projects", "Bob", 5, 3),
            new ReadingCourse("Data Science", "Carol", 150, 10)
        };
        for (Course c : courses) c.showProgress();
    }
}
class Course {
    String title;
    String instructor;
    Course(String title, String instructor) {
        this.title = title;
        this.instructor = instructor;
    }
    void showProgress() {
        System.out.println("Progress for " + title);
    }
}
class VideoCourse extends Course {
    int completion;
    int watchTime;
    VideoCourse(String title, String instructor, int completion, int watchTime) {
        super(title, instructor);
        this.completion = completion;
        this.watchTime = watchTime;
    }
    @Override
    void showProgress() {
        System.out.println("Video course " + title + ": " + completion + "% completed, " + watchTime + " mins watched.");
    }
}
class InteractiveCourse extends Course {
    int quizzesPassed;
    int projectsDone;
    InteractiveCourse(String title, String instructor, int quizzesPassed, int projectsDone) {
        super(title, instructor);
        this.quizzesPassed = quizzesPassed;
        this.projectsDone = projectsDone;
    }
    @Override
    void showProgress() {
        System.out.println("Interactive course " + title + ": " + quizzesPassed + " quizzes passed, " + projectsDone + " projects done.");
    }
}
class ReadingCourse extends Course {
    int pagesRead;
    int notesTaken;
    ReadingCourse(String title, String instructor, int pagesRead, int notesTaken) {
        super(title, instructor);
        this.pagesRead = pagesRead;
        this.notesTaken = notesTaken;
    }
    @Override
    void showProgress() {
        System.out.println("Reading course " + title + ": " + pagesRead + " pages read, " + notesTaken + " notes taken.");
    }
}
