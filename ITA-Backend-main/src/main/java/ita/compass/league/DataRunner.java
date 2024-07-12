package ita.compass.league;

import ita.compass.league.model.*;
import ita.compass.league.repository.ClubRepository;
import ita.compass.league.repository.MatchRepository;
import ita.compass.league.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataRunner implements CommandLineRunner {

    private final ClubRepository clubRepository;
    private final MatchRepository matchRepository;

    @Override
    public void run(String... args) throws Exception {

        Club club1 = Club.builder()
                .name("C1")
                .imageUrl("C1-LOGO-")
                .build();

        Club club2 = Club.builder()
                .name("Republika Srpska")
                .imageUrl("FK-REPUBLIKA-SRPSKA")
                .build();

        Club club3 = Club.builder()
                .name("Ljiljan")
                .imageUrl("b.h.-ljiljan-sc")
                .build();

        Club club4 = Club.builder()
                .name("Nikola Tesla")
                .imageUrl("fk-nikola-tesla-logo")
                .build();

        Club club5 = Club.builder()
                .name("Grasshoppers")
                .imageUrl("grasshoppers-logo")
                .build();

        Club club6 = Club.builder()
                .name("Lioneight")
                .imageUrl("lioneight-logo")
                .build();

        Club club7 = Club.builder()
                .name("Liths")
                .imageUrl("liths")
                .build();

        Club club8 = Club.builder()
                .name("Hammers")
                .imageUrl("sc-hammers")
                .build();

        Club club9 = Club.builder()
                .name("Wisloka")
                .imageUrl("wisloka")
                .build();

        clubRepository.saveAll(List.of(club1, club2, club3, club4, club5, club6, club7, club8, club9));

        LocalDateTime ldt1 = LocalDateTime.now().plusDays(19).plusHours(11).plusMinutes(56);
        LocalDateTime ldt2 = LocalDateTime.now().plusDays(42).plusHours(20).plusMinutes(34);
        LocalDateTime ldt3 = LocalDateTime.now().plusDays(13).plusHours(17).plusMinutes(7);
        LocalDateTime ldt4 = LocalDateTime.now().plusDays(26).plusHours(1).plusMinutes(49);
        LocalDateTime ldt5 = LocalDateTime.now().plusDays(30).plusHours(6).plusMinutes(15);

        Match match1 = Match.builder()
                .name("Club1_Club2_" + ldt1)
                .hostClub(club1)
                .guestClub(club2)
                .hostGoals(5)
                .guestGoals(2)
                .date(DateUtil.stringFromDate(ldt1))
                .halftimeGuestGoals(1)
                .halftimeHostGoals(2)
                .matchWeek(1)
                .field(Field.FIELD_1)
                .build();

        Match match2 = Match.builder()
                .name("Club3_Club4_" + ldt2)
                .hostClub(club3)
                .guestClub(club4)
                .hostGoals(1)
                .guestGoals(3)
                .date(DateUtil.stringFromDate(ldt2))
                .halftimeGuestGoals(2)
                .halftimeHostGoals(0)
                .matchWeek(2)
                .field(Field.FIELD_1)
                .build();

        Match match3 = Match.builder()
                .name("Club5_Club6_" + ldt3)
                .hostClub(club5)
                .guestClub(club6)
                .hostGoals(2)
                .guestGoals(2)
                .date(DateUtil.stringFromDate(ldt3))
                .halftimeGuestGoals(0)
                .halftimeHostGoals(0)
                .matchWeek(1)
                .field(Field.FIELD_1)
                .build();

        Match match4 = Match.builder()
                .name("Club7_Club8_" + ldt4)
                .hostClub(club7)
                .guestClub(club8)
                .hostGoals(3)
                .guestGoals(1)
                .date(DateUtil.stringFromDate(ldt4))
                .halftimeGuestGoals(0)
                .halftimeHostGoals(1)
                .matchWeek(2)
                .field(Field.FIELD_1)
                .build();

        Match match5 = Match.builder()
                .name("Club9_Club2_" + ldt5)
                .hostClub(club9)
                .guestClub(club2)
                .hostGoals(4)
                .guestGoals(1)
                .date(DateUtil.stringFromDate(ldt5))
                .halftimeGuestGoals(0)
                .halftimeHostGoals(2)
                .matchWeek(1)
                .field(Field.FIELD_1)
                .build();

        matchRepository.saveAll(new ArrayList<>(List.of(match1, match2, match3, match4, match5)));
        clubRepository.saveAll(List.of(club1, club2, club3, club4, club5, club6, club7, club8, club9));
    }

}
