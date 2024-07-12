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
public class MatchDto {
    private String name;
    private ClubDto hostClub;
    private ClubDto guestClub;
    private int hostGoals;
    private int guestGoals;
    private String date;
    private Field field;
    private boolean isWinner;
}
