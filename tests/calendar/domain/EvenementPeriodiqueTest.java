package calendar.domain;

import MyCalendar.calendar.domain.*;

import MyCalendar.calendar.domain.valueObject.DureeEvenement;
import MyCalendar.calendar.domain.valueObject.FrequenceRepetition;
import MyCalendar.calendar.domain.valueObject.TitreEvenement;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvenementPeriodiqueTest {

    @Test
    void unEvenementPeriodiqueGenereUneDescriptionAvecFrequence() {
        var titre = new TitreEvenement("Cours de Yoga");
        var date = LocalDateTime.of(2025, 4, 7, 18, 0);
        var duree = new DureeEvenement(60);
        var frequence = new FrequenceRepetition(7);

        EvenementPeriodique event = new EvenementPeriodique(titre, date, duree, frequence);

        String attendu = "Événement périodique : Cours de Yoga tous les 7 jours";
        assertEquals(attendu, event.description());
    }
}
