package MyCalendar.calendar.domain;

import java.util.Objects;

public class DureeEvenement {
    private final int minutes;

    public DureeEvenement(int minutes) {
        this.minutes = minutes;
    }

    public int minutes() {
        return minutes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DureeEvenement)) return false;
        DureeEvenement de = (DureeEvenement) o;
        return minutes == de.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minutes);
    }
}
