package calendar.domain;

import MyCalendar.calendar.domain.valueObject.DureeEvenement;
import MyCalendar.calendar.domain.RendezVous;
import MyCalendar.calendar.domain.valueObject.TitreEvenement;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RendezVousTest {

    @Test
    void unRendezVousPersonnelGenereUneDescriptionTextuelle() {
        var titre = new TitreEvenement("Dentiste");
        var date = LocalDateTime.of(2025, 4, 5, 10, 0);
        var duree = new DureeEvenement(60);

        RendezVous rdv = new RendezVous(titre, date, duree);

        String attendu = "RDV : Dentiste à 2025-04-05T10:00";
        assertEquals(attendu, rdv.description());
    }
}
