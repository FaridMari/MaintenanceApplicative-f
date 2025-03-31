package MyCalendar;

import MyCalendar.calendar.domain.Calendrier;
import MyCalendar.calendar.domain.Evenement;

import java.time.LocalDateTime;
import java.util.List;

public class CalendarManager {

    private final Calendrier calendrier = new Calendrier();

    public void ajouterEvenement(Evenement evenement) {
        calendrier.ajouter(evenement);
    }

    public List<Evenement> eventsDansPeriode(LocalDateTime debut, LocalDateTime fin) {
        return calendrier.evenementsDansPeriode(debut, fin);
    }

    public boolean conflit(Evenement e1, Evenement e2) {
        return e1.chevauche(e2);
    }

    public void afficherEvenements() {
        calendrier.tous().forEach(e -> System.out.println(e.description()));
    }
}
