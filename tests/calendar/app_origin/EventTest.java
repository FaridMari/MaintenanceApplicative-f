package calendar.app_origin;

import MyCalendar.CalendarManager;
import MyCalendar.Event;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EventTest {

    @Test
    void descriptionPourRdvPersonnelEstCorrecte() {
        var date = LocalDateTime.of(2025, 4, 5, 10, 0);
        var event = new Event("RDV_PERSONNEL", "Dentiste", "Alice", date, 60, "", "", 0);

        String attendu = "RDV : Dentiste à 2025-04-05T10:00";
        assertEquals(attendu, event.description());
    }

    @Test
    void descriptionPourReunionEstCorrecte() {
        var date = LocalDateTime.of(2025, 4, 6, 14, 0);
        var event = new Event("REUNION", "Projet", "Alice", date, 90, "Salle A", "Alice, Bob", 0);

        String attendu = "Réunion : Projet à Salle A avec Alice, Bob";
        assertEquals(attendu, event.description());
    }


    @Test
    void descriptionPourEvenementPeriodiqueEstCorrecte() {
        var date = LocalDateTime.of(2025, 4, 1, 18, 0);
        var event = new Event("PERIODIQUE", "Yoga", "Roger", date, 60, "", "", 7);

        String attendu = "Événement périodique : Yoga tous les 7 jours";
        assertEquals(attendu, event.description());
    }

}
