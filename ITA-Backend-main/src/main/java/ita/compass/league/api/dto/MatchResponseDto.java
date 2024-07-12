package ita.compass.league.api.dto;

import ita.compass.league.model.Field;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchResponseDto {
    private String name;
    private ClubDto hostClub;
    private ClubDto guestClub;
    private int hostGoals;
    private int guestGoals;
    private String date;
    private int matchWeek;
    private int halftimeHostGoals;
    private int halftimeGuestGoals;
    private Field field;
}
