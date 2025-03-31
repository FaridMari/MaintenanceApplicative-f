package calendar.domain;

import MyCalendar.calendar.domain.*;
import MyCalendar.calendar.domain.valueObject.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalendrierTest {

    @Test
    void unEvenementAjouteEstPresentDansLaListe() {
        var calendrier = new Calendrier();

        var titre = new TitreEvenement("Dentiste");
        var date = LocalDateTime.of(2025, 4, 5, 10, 0);
        var duree = new DureeEvenement(60);

        var rdv = new RendezVous(titre, new DateEvenement(date), duree);


                calendrier.ajouter(rdv);

        assertTrue(calendrier.tous().contains(rdv));
        assertEquals(1, calendrier.tous().size());
    }

    @Test
    void retourneSeulementLesEvenementsDansUnePeriode() {
        var calendrier = new Calendrier();

        var titre1 = new TitreEvenement("Dentiste");
        var titre2 = new TitreEvenement("Course");

        var date1 = new DateEvenement(LocalDateTime.of(2025, 4, 5, 10, 0));
        var date2 = new DateEvenement(LocalDateTime.of(2025, 4, 20, 9, 0));

        var duree = new DureeEvenement(60);

        calendrier.ajouter(new RendezVous(titre1, date1, duree)); // dans la période
        calendrier.ajouter(new RendezVous(titre2, date2, duree)); // en dehors

        var debut = new DateEvenement(LocalDateTime.of(2025, 4, 1, 0, 0));
        var fin = new DateEvenement(LocalDateTime.of(2025, 4, 10, 23, 59));

        var resultat = calendrier.evenementsDansPeriode(debut, fin);

        assertEquals(1, resultat.size());
        assertEquals(titre1, resultat.get(0).titre());
    }




    @Test
    void peutSupprimerUnEvenementParSonId() {
        var calendrier = new Calendrier();

        var rdv = new RendezVous(
                new TitreEvenement("Vaccin"),
                new DateEvenement(LocalDateTime.of(2025, 4, 10, 15, 0)),
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
                new DateEvenement(LocalDateTime.of(2025, 4, 15, 10, 0)),
                new DureeEvenement(60) // 10h00 --> 11h00
        );

        var rdv2 = new RendezVous(
                new TitreEvenement("Massage"),
                new DateEvenement(LocalDateTime.of(2025, 4, 15, 10, 30)),
                new DureeEvenement(30) // 10h30 --> 11h00
        );

        assertTrue(rdv1.chevauche(rdv2));
        assertTrue(rdv2.chevauche(rdv1));
    }

    @Test
    void detecteConflitLorsquUnNouvelEvenementChevaucheUnExistant() {
        var calendrier = new Calendrier();

        var rdv1 = new RendezVous(
                new TitreEvenement("Cours"),
                new DateEvenement(LocalDateTime.of(2025, 4, 20, 14, 0)),
                new DureeEvenement(60)
        );

        var rdv2 = new RendezVous(
                new TitreEvenement("Visio"),
                new DateEvenement(LocalDateTime.of(2025, 4, 20, 14, 30)),
                new DureeEvenement(30)
        );

        calendrier.ajouter(rdv1);

        assertTrue(calendrier.estEnConflitAvec(rdv2));
    }

    @Test
    void unEvenementPeriodiqueApparaitDansChaqueOccurrenceDansLaPeriode() {
        var calendrier = new Calendrier();

        var event = new EvenementPeriodique(
                new TitreEvenement("Yoga"),
                new DateEvenement(LocalDateTime.of(2025, 4, 1, 18, 0)),
                new DureeEvenement(60),
                new FrequenceRepetition(7) // toutes les semaines
        );

        calendrier.ajouter(event);

        var debut = new DateEvenement(LocalDateTime.of(2025, 4, 1, 0, 0));
        var fin = new DateEvenement(LocalDateTime.of(2025, 4, 30, 23, 59));

        var resultat = calendrier.evenementsDansPeriode(debut, fin);

        assertTrue(resultat.contains(event));
    }


    @Test
    void peutGenererUneDescriptionDesEvenementsDansUnePeriode() {
        var calendrier = new Calendrier();

        var rdv = new RendezVous(
                new TitreEvenement("Dentiste"),
                new DateEvenement(LocalDateTime.of(2025, 4, 5, 10, 0)),
                new DureeEvenement(60)
        );

        var reunion = new Reunion(
                new TitreEvenement("Projet"),
                new DateEvenement(LocalDateTime.of(2025, 4, 5, 14, 0)),
                new DureeEvenement(90),
                new LieuEvenement("Salle B"),
                new ParticipantsEvenement(List.of("Alice", "Bob"))
        );

        calendrier.ajouter(rdv);
        calendrier.ajouter(reunion);

        var debut = new DateEvenement(LocalDateTime.of(2025, 4, 1, 0, 0));
        var fin = new DateEvenement(LocalDateTime.of(2025, 4, 6, 23, 59));

        var description = calendrier.decrirePeriode(debut, fin);

        assertTrue(description.contains("RDV : Dentiste à 2025-04-05T10:00"));
        assertTrue(description.contains("Réunion : Projet à Salle B avec Alice, Bob"));
    }


}
