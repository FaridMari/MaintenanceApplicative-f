package MyCalendar.calendar.domain;

import MyCalendar.calendar.domain.valueObject.DureeEvenement;
import MyCalendar.calendar.domain.valueObject.TitreEvenement;

import java.time.LocalDateTime;

public abstract class Evenement {
    protected final TitreEvenement titre;
    protected final LocalDateTime dateDebut;
    protected final DureeEvenement duree;

    protected Evenement(TitreEvenement titre, LocalDateTime dateDebut, DureeEvenement duree) {
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.duree = duree;
    }

    public abstract String description();
}
