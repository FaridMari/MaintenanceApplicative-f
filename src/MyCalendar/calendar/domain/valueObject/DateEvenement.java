package MyCalendar.calendar.domain.valueObject;

import java.time.LocalDateTime;
import java.util.Objects;

public class DateEvenement {
    private final LocalDateTime value;

    public DateEvenement(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime value() {
        return value;
    }


    public boolean isBefore(DateEvenement other) {
        return value.isBefore(other.value());
    }

    public boolean isAfter(DateEvenement other) {
        return value.isAfter(other.value());
    }

    public boolean isBetween(DateEvenement debut, DateEvenement fin) {
        return !isBefore(debut) && !isAfter(fin);
    }

    public DateEvenement plusMonths(long months) {
        return new DateEvenement(value.plusMonths(months));
    }

    public DateEvenement plusDays(long days) {
        return new DateEvenement(value.plusDays(days));
    }

    public DateEvenement minusDays(long days) {
        return new DateEvenement(value.minusDays(days));
    }

    public DateEvenement minusSeconds(long seconds) {
        return new DateEvenement(value.minusSeconds(seconds));
    }

    public DateEvenement plusHours(long hours) {
        return new DateEvenement(value.plusHours(hours));
    }

    public DateEvenement minusHours(long hours) {
        return new DateEvenement(value.minusHours(hours));
    }


    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DateEvenement d)) return false;
        return value.equals(d.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
