package MyCalendar.calendar.infrastructure;

import MyCalendar.*;
import MyCalendar.calendar.domain.*;
import MyCalendar.calendar.domain.valueObject.*;

public class EventMapper {

    public static Evenement map(Event e) {
        if (e.type.equals("RDV_PERSONNEL")) {
            return new RendezVous(
                    new TitreEvenement(e.title),
                    e.dateDebut,
                    new DureeEvenement(e.dureeMinutes)
            );
        }

        throw new UnsupportedOperationException("Type d'événement non pris en charge: " + e.type);
    }
}
