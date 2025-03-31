package MyCalendar.calendar.domain;

import MyCalendar.calendar.domain.valueObject.*;

public class RendezVous extends Evenement {
    public RendezVous(TitreEvenement titre, DateEvenement dateDebut, DureeEvenement duree) {
        super(titre, dateDebut, duree);
    }

    @Override
    public String description() {
        return "RDV : " + titre().value() + " à " + dateDebut().toString();
    }
}
