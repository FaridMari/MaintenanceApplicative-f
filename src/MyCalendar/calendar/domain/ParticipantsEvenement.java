package MyCalendar.calendar.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ParticipantsEvenement {
    private final List<String> noms;

    public ParticipantsEvenement(List<String> noms) {
        this.noms = List.copyOf(noms); // immuable
    }

    public List<String> noms() {
        return Collections.unmodifiableList(noms);
    }

    public String affichage() {
        return noms.stream().collect(Collectors.joining(", "));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParticipantsEvenement)) return false;
        ParticipantsEvenement that = (ParticipantsEvenement) o;
        return Objects.equals(noms, that.noms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noms);
    }
}
