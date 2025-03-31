package calendar.domain;

import MyCalendar.calendar.domain.DureeEvenement;
import MyCalendar.calendar.domain.Reunion;
import MyCalendar.calendar.domain.TitreEvenement;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {

    @Test
    void uneReunionGenereUneDescriptionAvecParticipantsEtLieu() {
        var titre = new TitreEvenement("Point projet");
        var date = LocalDateTime.of(2025, 4, 6, 14, 30);
        var duree = new DureeEvenement(90);
        var lieu = "Salle A201";
        var participants = "Alice, Bob, Charlie";

        Reunion reunion = new Reunion(titre, date, duree, lieu, participants);

        String attendu = "Réunion : Point projet à Salle A201 avec Alice, Bob, Charlie";
        assertEquals(attendu, reunion.description());
    }
}
