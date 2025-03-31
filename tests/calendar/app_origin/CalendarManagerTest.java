package calendar.app_origin;

import MyCalendar.CalendarManager;
import MyCalendar.Event;
import MyCalendar.calendar.domain.EvenementPeriodique;
import MyCalendar.calendar.domain.RendezVous;
import MyCalendar.calendar.domain.Reunion;
import MyCalendar.calendar.domain.valueObject.*;
import MyCalendar.calendar.infrastructure.EventMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarManagerTest {

    @Test
    void ajouterUnRdvEstBienRecupereDansUnePeriode() {
        var manager = new CalendarManager();
        var date = LocalDateTime.of(2025, 4, 5, 10, 0);

        manager.ajouterEvenement(
                new RendezVous(
                        new TitreEvenement("Dentiste"),
                        new DateEvenement(date),
                        new DureeEvenement(60)
                )
        );

        var result = manager.eventsDansPeriode(
                date.minusHours(1),
                date.plusHours(1)
        );

        assertEquals(1, result.size());
        assertEquals("RDV : Dentiste à 2025-04-05T10:00", result.get(0).description());
    }



    @Test
    void ajouterUneReunionDonneUneBonneDescription() {
        var manager = new CalendarManager();
        var date = LocalDateTime.of(2025, 4, 6, 14, 0);

        new Reunion(
                new TitreEvenement("Projet"),
                new DateEvenement(date),
                new DureeEvenement(90),
                new LieuEvenement("Salle A"),
                new ParticipantsEvenement(List.of("Alice", "Bob"))
        );

        var result = manager.eventsDansPeriode(date.minusDays(1), date.plusDays(1));

        assertEquals(1, result.size());
        assertEquals("Réunion : Projet à Salle A avec Alice, Bob", result.get(0).description());
    }


    @Test
    void evenementPeriodiqueApparaitDansUnePeriodeCiblee() {
        var manager = new CalendarManager();
        var date = LocalDateTime.of(2025, 4, 1, 18, 0);

        manager.ajouterEvenement(
                new EvenementPeriodique(
                        new TitreEvenement("Yoga"),
                        new DateEvenement(date),
                        new DureeEvenement(60),
                        new FrequenceRepetition(7)
                )
        );

        var result = manager.eventsDansPeriode(
                LocalDateTime.of(2025, 4, 1, 0, 0),
                LocalDateTime.of(2025, 4, 30, 23, 59)
        );

        assertEquals(1, result.size());
        assertTrue(result.get(0).description().contains("Événement périodique : Yoga tous les 7 jours"));
    }



    @Test
    void detecteConflitEntreDeuxRdvs() {
        var manager = new CalendarManager();

        var date1 = LocalDateTime.of(2025, 4, 10, 10, 0);
        var date2 = LocalDateTime.of(2025, 4, 10, 10, 30);

        var rdv1 = new Event("RDV_PERSONNEL", "A", "A", date1, 60, "", "", 0);
        var rdv2 = new Event("RDV_PERSONNEL", "B", "B", date2, 60, "", "", 0);

        var e1 = EventMapper.map(rdv1);
        var e2 = EventMapper.map(rdv2);

        assertTrue(manager.conflit(e1, e2));
    }
}
