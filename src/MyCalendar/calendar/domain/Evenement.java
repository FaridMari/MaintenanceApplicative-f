package MyCalendar.calendar.domain;

import MyCalendar.calendar.domain.valueObject.DateEvenement;
import MyCalendar.calendar.domain.valueObject.DureeEvenement;
import MyCalendar.calendar.domain.valueObject.EventId;
import MyCalendar.calendar.domain.valueObject.TitreEvenement;

public abstract class Evenement {
    protected final TitreEvenement titre;
    protected final DateEvenement dateDebut;
    protected final DureeEvenement duree;
    protected final EventId id;

    protected Evenement(TitreEvenement titre, DateEvenement dateDebut, DureeEvenement duree) {
        this.id = new EventId();
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.duree = duree;
    }

    public abstract String description();

    public TitreEvenement titre() {
        return titre;
    }

    public DateEvenement dateDebut() {
        return dateDebut;
    }

    public EventId id() {
        return id;
    }

    public boolean chevauche(Evenement autre) {
        var fin = this.dateDebut.value().plusMinutes(this.duree.minutes());
        var finAutre = autre.dateDebut.value().plusMinutes(autre.duree.minutes());

        return this.dateDebut.value().isBefore(finAutre) && fin.isAfter(autre.dateDebut.value());
    }
}
