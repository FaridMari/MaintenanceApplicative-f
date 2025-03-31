package MyCalendar.calendar.domain;

import java.time.LocalDateTime;

public class EvenementPeriodique extends Evenement {
    private final FrequenceRepetition frequence;

    public EvenementPeriodique(TitreEvenement titre, LocalDateTime dateDebut, DureeEvenement duree,
                               FrequenceRepetition frequence) {
        super(titre, dateDebut, duree);
        this.frequence = frequence;
    }

    @Override
    public String description() {
        return "Événement périodique : " + titre.value() + " tous les " + frequence.jours() + " jours";
    }
}
