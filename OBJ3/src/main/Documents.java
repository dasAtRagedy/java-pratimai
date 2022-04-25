package main;

import java.time.LocalDateTime;

public class Documents {
    protected String author;
    private LocalDateTime creationDate;
    protected LocalDateTime modificationDate;
    protected LocalDateTime dueDate;

    public Documents(String author) {
        this.author = author;
        this.creationDate = LocalDateTime.now();
        this.modificationDate = LocalDateTime.now();
        this.dueDate = LocalDateTime.now();
    }

    public final void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void printAuthor() {
        System.out.println(this.author);
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public void delayDueDate() {
        this.dueDate = this.dueDate.plusDays(1);
    }

    // get due date
    public LocalDateTime getDueDate() {
        return this.dueDate;
    }
}