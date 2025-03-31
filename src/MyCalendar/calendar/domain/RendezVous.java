package MyCalendar.calendar.domain;

import MyCalendar.calendar.domain.valueObject.DureeEvenement;
import MyCalendar.calendar.domain.valueObject.TitreEvenement;

import java.time.LocalDateTime;

public class RendezVous extends Evenement {

    public RendezVous(TitreEvenement titre, LocalDateTime dateDebut, DureeEvenement duree) {
        super(titre, dateDebut, duree);
    }

    @Override
    public String description() {
        return "RDV : " + titre.value() + " à " + dateDebut.toString();
    }
}
