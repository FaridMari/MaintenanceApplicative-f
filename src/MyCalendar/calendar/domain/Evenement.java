package MyCalendar.calendar.domain;

import MyCalendar.calendar.domain.valueObject.DureeEvenement;
import MyCalendar.calendar.domain.valueObject.EventId;
import MyCalendar.calendar.domain.valueObject.TitreEvenement;

import java.time.LocalDateTime;

public abstract class Evenement {
    protected final TitreEvenement titre;
    protected final LocalDateTime dateDebut;
    protected final DureeEvenement duree;
    protected final EventId id;

    protected Evenement(TitreEvenement titre, LocalDateTime dateDebut, DureeEvenement duree) {
        this.id = new EventId();
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.duree = duree;
    }


    public abstract String description();

    public TitreEvenement titre() {
        return titre;
    }

    public EventId id() {
        return id;
    }


}
