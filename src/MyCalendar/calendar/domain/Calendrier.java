package MyCalendar.calendar.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calendrier {
    private final List<Evenement> evenements = new ArrayList<>();

    public void ajouter(Evenement evenement) {
        evenements.add(evenement);
    }

    public List<Evenement> evenementsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return evenements.stream()
                .filter(e -> !e.dateDebut.isBefore(debut) && !e.dateDebut.isAfter(fin))
                .toList();
    }

    public List<Evenement> tous() {
        return List.copyOf(evenements);
    }
}
