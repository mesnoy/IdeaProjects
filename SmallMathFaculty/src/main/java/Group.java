import java.time.LocalTime;

public class Group {
    private Day day;
    private LocalTime time;

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Group(Day day, LocalTime time) {
        this.day = day;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Group{" +
                "day=" + day +
                ", time=" + time +
                '}';
    }
}
