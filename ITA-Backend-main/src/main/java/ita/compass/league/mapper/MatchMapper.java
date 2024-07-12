package ita.compass.league.mapper;

import ita.compass.league.api.dto.ClubDto;
import ita.compass.league.api.dto.MatchResponseDto;
import ita.compass.league.model.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {
    public MatchResponseDto mapMatchToMatchResponseDto(Match match) {
        return MatchResponseDto.builder()
                .name(match.getName())
                .hostClub(ClubDto.builder()
                        .name(match.getHostClub().getName())
                        .imageUrl(match.getHostClub().getImageUrl())
                        .build())
                .guestClub(ClubDto.builder()
                        .name(match.getGuestClub().getName())
                        .imageUrl(match.getGuestClub().getImageUrl())
                        .build())
                .hostGoals(match.getHostGoals())
                .guestGoals(match.getGuestGoals())
                .date(match.getDate())
                .matchWeek(match.getMatchWeek())
                .halftimeHostGoals(match.getHalftimeHostGoals())
                .halftimeGuestGoals(match.getHalftimeGuestGoals())
                .field(match.getField())
                .build();
    }
}
