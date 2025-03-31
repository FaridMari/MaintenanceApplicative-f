package calendar.app_origin;

import MyCalendar.CalendarManager;
import MyCalendar.Event;
import MyCalendar.calendar.infrastructure.EventMapper;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarManagerTest {

    @Test
    void ajouterUnRdvEstBienRecupereDansUnePeriode() {
        var manager = new CalendarManager();
        var date = LocalDateTime.of(2025, 4, 5, 10, 0);

        manager.ajouterEvent("RDV_PERSONNEL", "Dentiste", "Alice", date, 60, "", "", 0);

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

        manager.ajouterEvent("REUNION", "Projet", "Alice", date, 90, "Salle A", "Alice, Bob", 0);

        var result = manager.eventsDansPeriode(date.minusDays(1), date.plusDays(1));

        assertEquals(1, result.size());
        assertEquals("Réunion : Projet à Salle A avec Alice, Bob", result.get(0).description());
    }


    @Test
    void evenementPeriodiqueApparaitDansUnePeriodeCiblee() {
        var manager = new CalendarManager();
        var date = LocalDateTime.of(2025, 4, 1, 18, 0);

        manager.ajouterEvent("PERIODIQUE", "Yoga", "Roger", date, 60, "", "", 7);

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
