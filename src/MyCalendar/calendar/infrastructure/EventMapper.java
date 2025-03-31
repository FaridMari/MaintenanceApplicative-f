package MyCalendar.calendar.infrastructure;

import MyCalendar.*;
import MyCalendar.calendar.domain.*;
import MyCalendar.calendar.domain.valueObject.*;

import java.util.List;

public class EventMapper {

    public static Evenement map(Event e) {
        return switch (e.type) {
            case "RDV_PERSONNEL" -> new RendezVous(
                    new TitreEvenement(e.title),
                    e.dateDebut,
                    new DureeEvenement(e.dureeMinutes)
            );
            case "REUNION" -> new Reunion(
                    new TitreEvenement(e.title),
                    e.dateDebut,
                    new DureeEvenement(e.dureeMinutes),
                    new LieuEvenement(e.lieu),
                    new ParticipantsEvenement(List.of(e.participants.split(",\\s*")))
            );
            case "PERIODIQUE" -> new EvenementPeriodique(
                    new TitreEvenement(e.title),
                    e.dateDebut,
                    new DureeEvenement(e.dureeMinutes),
                    new FrequenceRepetition(e.frequenceJours)
            );
            default -> throw new UnsupportedOperationException("Type d'événement non pris en charge: " + e.type);
        };
    }


}
