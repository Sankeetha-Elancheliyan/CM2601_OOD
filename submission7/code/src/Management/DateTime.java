package Management;

import java.time.LocalDateTime;

public class DateTime {
    private LocalDateTime dateTime;

    public DateTime() {
        LocalDateTime dateTime=LocalDateTime.now();
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "DateTime{" +
                "dateTime=" + dateTime +
                '}';
    }
//    public static void main(String[] args) {
//        DateTime v = new DateTime();
//        System.out.println(v.getDateTime());
//    }
}
