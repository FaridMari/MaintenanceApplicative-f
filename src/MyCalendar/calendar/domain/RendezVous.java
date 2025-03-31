package MyCalendar.calendar.domain;

import java.time.LocalDateTime;

public class RendezVous {
    private final TitreEvenement titre;
    private final LocalDateTime dateDebut;
    private final DureeEvenement duree;

    public RendezVous(TitreEvenement titre, LocalDateTime dateDebut, DureeEvenement duree) {
        this.titre = titre;
        this.dateDebut = dateDebut;
        this.duree = duree;
    }

    public String description() {
        return "RDV : " + titre.value() + " à " + dateDebut.toString();
    }
}
