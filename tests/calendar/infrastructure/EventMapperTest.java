package calendar.infrastructure;

import MyCalendar.*;
import MyCalendar.calendar.domain.*;
import MyCalendar.calendar.domain.valueObject.*;
import MyCalendar.calendar.infrastructure.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EventMapperTest {

    @Test
    void peutMapperUnEventDeTypeRDV_PERSONNEL() {
        var event = new Event(
                "RDV_PERSONNEL",
                "Dentiste",
                "Roger",
                LocalDateTime.of(2025, 4, 10, 9, 0),
                60,
                "", "", 0
        );

        Evenement resultat = EventMapper.map(event);

        assertTrue(resultat instanceof RendezVous);
        assertEquals("Dentiste", resultat.titre().value());
    }

    @Test
    void peutMapperUnEventDeTypeREUNION() {
        var event = new Event(
                "REUNION",
                "Projet",
                "Alice",
                LocalDateTime.of(2025, 4, 15, 14, 0),
                90,
                "Salle B",
                "Alice, Bob",
                0
        );

        Evenement resultat = EventMapper.map(event);

        assertTrue(resultat instanceof Reunion);
        assertEquals("Projet", resultat.titre().value());
    }

    @Test
    void peutMapperUnEventDeTypePERIODIQUE() {
        var event = new Event(
                "PERIODIQUE",
                "Yoga",
                "Roger",
                LocalDateTime.of(2025, 4, 1, 18, 0),
                60,
                "", "", 7
        );

        Evenement resultat = EventMapper.map(event);

        assertTrue(resultat instanceof EvenementPeriodique);
        assertEquals("Yoga", resultat.titre().value());
    }

}
