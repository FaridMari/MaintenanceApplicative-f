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

    @Test
    void retourneSeulementLesEvenementsDansUnePeriode() {
        var calendrier = new Calendrier();

        var titre1 = new TitreEvenement("Dentiste");
        var titre2 = new TitreEvenement("Course");

        var date1 = LocalDateTime.of(2025, 4, 5, 10, 0);
        var date2 = LocalDateTime.of(2025, 4, 20, 9, 0);

        var duree = new DureeEvenement(60);

        calendrier.ajouter(new RendezVous(titre1, date1, duree)); // dans la période
        calendrier.ajouter(new RendezVous(titre2, date2, duree)); // en dehors

        var debut = LocalDateTime.of(2025, 4, 1, 0, 0);
        var fin = LocalDateTime.of(2025, 4, 10, 23, 59);

        var resultat = calendrier.evenementsDansPeriode(debut, fin);

        assertEquals(1, resultat.size());
        assertEquals(titre1, resultat.get(0).titre());
    }

    @Test
    void peutSupprimerUnEvenementParSonId() {
        var calendrier = new Calendrier();

        var rdv = new RendezVous(
                new TitreEvenement("Vaccin"),
                LocalDateTime.of(2025, 4, 10, 15, 0),
                new DureeEvenement(30)
        );

        calendrier.ajouter(rdv);

        assertEquals(1, calendrier.tous().size());

        var id = rdv.id();

        calendrier.supprimerParId(id);

        assertEquals(0, calendrier.tous().size());
    }

    @Test
    void deuxEvenementsQuiSeChevauchentSontDetectesCommeConflits() {
        var rdv1 = new RendezVous(
                new TitreEvenement("Consultation"),
                LocalDateTime.of(2025, 4, 15, 10, 0),
                new DureeEvenement(60) // 10h00 --> 11h00
        );

        var rdv2 = new RendezVous(
                new TitreEvenement("Massage"),
                LocalDateTime.of(2025, 4, 15, 10, 30),
                new DureeEvenement(30) // 10h30 --> 11h00
        );

        assertTrue(rdv1.chevauche(rdv2));
        assertTrue(rdv2.chevauche(rdv1));
    }



}
