package ita.compass.league.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "club", indexes = {@Index(name = "club_name_ix", columnList = "name")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @OneToMany(mappedBy = "hostClub")
    private List<Match> hostMatches;

    @OneToMany(mappedBy = "guestClub")
    private List<Match> guestMatches;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Club club = (Club) o;
        return Objects.equals(id, club.id) && Objects.equals(name, club.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
