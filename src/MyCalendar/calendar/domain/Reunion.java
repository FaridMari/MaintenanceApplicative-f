package MyCalendar.calendar.domain;

import java.time.LocalDateTime;

public class Reunion extends Evenement {
    private final LieuEvenement lieu;
    private final ParticipantsEvenement participants;

    public Reunion(TitreEvenement titre, LocalDateTime dateDebut, DureeEvenement duree,
                   LieuEvenement lieu, ParticipantsEvenement participants) {
        super(titre, dateDebut, duree);
        this.lieu = lieu;
        this.participants = participants;
    }

    @Override
    public String description() {
        return "Réunion : " + titre.value() + " à " + lieu.value() + " avec " + participants.affichage();
    }
}
