package MyCalendar.calendar.domain;

import java.time.LocalDateTime;

public class Reunion extends Evenement {
    private final String lieu;
    private final String participants;

    public Reunion(TitreEvenement titre, LocalDateTime dateDebut, DureeEvenement duree,
                   String lieu, String participants) {
        super(titre, dateDebut, duree);
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + titre.value() + " à " + lieu + " avec " + participants;
    }
}
