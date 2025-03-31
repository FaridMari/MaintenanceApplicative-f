package calendar.domain;

import MyCalendar.calendar.domain.*;
import MyCalendar.calendar.domain.valueObject.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {

    @Test
    void uneReunionGenereUneDescriptionAvecParticipantsEtLieu() {
        var titre = new TitreEvenement("Point projet");
        var date = LocalDateTime.of(2025, 4, 6, 14, 30);
        var duree = new DureeEvenement(90);
        var lieu = new LieuEvenement("Salle A201");
        var participants = new ParticipantsEvenement(List.of("Alice", "Bob", "Charlie"));

        Reunion reunion = new Reunion(
                titre,
                new DateEvenement(date), // ✅ encapsulation
                duree,
                lieu,
                participants
        );

        String attendu = "Réunion : Point projet à Salle A201 avec Alice, Bob, Charlie";
        assertEquals(attendu, reunion.description());
    }
}