package document_types;

import document_types.helpers.Event;
import main.Documents;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CalendarDocument extends Documents {
    private ArrayList<Event> events;
    public CalendarDocument(String author) {
        super(author);
    }

    // add new event
    public void addEvent(Event event) {
        events.add(event);
        super.modificationDate = LocalDateTime.now();
    }
    // remove event
    public void removeEvent(Event event) {
        events.remove(event);
        super.modificationDate = LocalDateTime.now();
    }
    // get events
    public ArrayList<Event> getEvents() {
        return events;
    }

    @Override
    public void delayDueDate() {
        this.dueDate = this.dueDate.plusDays(7);
    }
}
