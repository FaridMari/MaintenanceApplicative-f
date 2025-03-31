package calendar.domain;

import MyCalendar.calendar.domain.*;
import MyCalendar.calendar.domain.valueObject.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class CalendrierTest {

    @Test
    void unEvenementAjouteEstPresentDansLaListe() {
        var calendrier = new Calendrier();

        var titre = new TitreEvenement("Dentiste");
        var date = LocalDateTime.of(2025, 4, 5, 10, 0);
        var duree = new DureeEvenement(60);

        var rdv = new RendezVous(titre, date, duree);

        calendrier.ajouter(rdv);

        assertTrue(calendrier.tous().contains(rdv));
        assertEquals(1, calendrier.tous().size());
    }
}
