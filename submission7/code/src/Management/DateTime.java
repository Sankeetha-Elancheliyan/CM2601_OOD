package Management;

import java.time.LocalDateTime;

public class DateTime {
    // Field to store the current date and time
    private LocalDateTime dateTime;

    // Constructor to initialize the dateTime field with the current date and time
    public DateTime() {
        this.dateTime = LocalDateTime.now();
    }

    // Getter for the dateTime field
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    // toString method to create a string representation of a DateTime object
    @Override
    public String toString() {
        return "DateTime{" +
                "dateTime=" + dateTime +
                '}';
    }
}
