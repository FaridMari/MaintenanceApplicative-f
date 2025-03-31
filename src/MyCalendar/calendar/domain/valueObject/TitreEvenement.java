package MyCalendar.calendar.domain.valueObject;

import java.util.Objects;

public class TitreEvenement {
    private final String value;

    public TitreEvenement(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TitreEvenement)) return false;
        TitreEvenement that = (TitreEvenement) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
