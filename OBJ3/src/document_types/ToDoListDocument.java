package document_types;

import document_types.helpers.Task;
import main.Documents;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ToDoListDocument extends Documents {
    private ArrayList<Task> tasks;
    public ToDoListDocument(String author) {
        super(author);
    }

    // add task to the list
    public void addTask(Task task) {
        tasks.add(task);
        setModificationDate(LocalDateTime.now());
    }
    // remove task from the list
    public void removeTask(Task task) {
        tasks.remove(task);
        setModificationDate(LocalDateTime.now());
    }
    // get the list of tasks
    public ArrayList<Task> getTasks() {
        return tasks;
    }


}
