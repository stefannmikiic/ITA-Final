package ita.compass.league.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "match", indexes = {@Index(name = "match_name_ix", columnList = "name")})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "host_club_id")
    private Club hostClub;

    @ManyToOne
    @JoinColumn(name = "guest_club_id")
    private Club guestClub;

    @Column(name = "host_goals", nullable = false)
    private int hostGoals;

    @Column(name = "guest_goals", nullable = false)
    private int guestGoals;

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "match_week", nullable = false)
    private int matchWeek;

    @Column(name = "halftime_host_goals", nullable = false)
    private int halftimeHostGoals;

    @Column(name = "halftime_guest_goals", nullable = false)
    private int halftimeGuestGoals;

    @Column(name = "field", nullable = false)
    @Enumerated(EnumType.STRING)
    private Field field;
}
