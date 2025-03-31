package MyCalendar.calendar.domain.valueObject;

import java.util.Objects;

public class LieuEvenement {
    private final String nom;

    public LieuEvenement(String nom) {
        this.nom = nom;
    }

    public String value() {
        return nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LieuEvenement)) return false;
        LieuEvenement le = (LieuEvenement) o;
        return Objects.equals(nom, le.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
