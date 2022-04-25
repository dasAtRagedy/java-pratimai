package document_types.helpers;

import java.time.LocalDate;

public class Event {
    private String name;
    private LocalDate date;
    private String location;
    private String description;

    public Event(String name, LocalDate date, String location, String description) {
        this.name = name;
        this.date = date;
        this.location = location;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "children.Event{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
