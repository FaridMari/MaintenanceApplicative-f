package MyCalendar.calendar.domain.valueObject;

import java.util.Objects;

public class FrequenceRepetition {
    private final int jours;

    public FrequenceRepetition(int jours) {
        if (jours <= 0) {
            throw new IllegalArgumentException("La fréquence doit être strictement positive.");
        }
        this.jours = jours;
    }

    public int jours() {
        return jours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FrequenceRepetition)) return false;
        FrequenceRepetition fr = (FrequenceRepetition) o;
        return jours == fr.jours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(jours);
    }
}
