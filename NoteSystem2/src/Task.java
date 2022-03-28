import java.time.LocalDateTime;

public class Task {
    private static final int CHARACTER_LIMIT = 1024;

    // fields accessible by get/set
    private boolean isFinished = false; // initialized at start
    private static String author;
    private String name;
    private final LocalDateTime dateCreated = LocalDateTime.now();
    private LocalDateTime dateDeadline;
    private LocalDateTime dateFinished;

    // constructors, one without arguments
    public Task() {
        this.author = "Unknown";
        this.name = "untitled";
        this.dateDeadline = null;
        this.dateFinished = null;
    }
    public Task(String author, String name, LocalDateTime dateDeadline) {
        this.author = author;
        this.name = name;
        this.dateDeadline = dateDeadline;
    }

    public boolean isFinished() {
        return isFinished;
    }
    public void setFinished(boolean finished) {
        isFinished = finished;
        dateFinished = LocalDateTime.now();
    }


    // final static method
    public final static int getCharacterLimit(){
        return CHARACTER_LIMIT;
    }
    /* Explanation to self:
    * Static method can be called without instantiating a class
    * Final method cannot be overridden
    */ // <-- keywords final and static for methods explained here

    // Overloaded method
    public void changeDate(){
        this.dateDeadline = null;
        this.dateFinished = null;
    }
    public void changeDate(LocalDateTime dateDeadline, LocalDateTime dateFinished){
        this.dateDeadline = dateDeadline;
        this.dateFinished = dateFinished;
    }

    // println method
    private void println(){
        System.out.println("Author of the program: " + author);
        System.out.println("Name of the program: " + name);
        System.out.println("Task creation date: " + dateCreated);
        System.out.println("Task deadline: " + dateDeadline);
        System.out.println("The task is " + (isFinished ? "finished." : "not finished."));
    }
}
