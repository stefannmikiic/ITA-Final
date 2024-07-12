package ita.compass.league.api.controller;

import ita.compass.league.api.SoccerLeagueApi;
import ita.compass.league.api.dto.ClubResponseDto;
import ita.compass.league.api.dto.MatchResponseDto;
import ita.compass.league.service.ClubService;
import ita.compass.league.service.MatchService;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class SoccerLeagueController implements SoccerLeagueApi {
    private final MatchService matchService;
    private final ClubService clubService;

    @Override
    public ResponseEntity<MatchResponseDto> getMatch(@NotEmpty(message = "Field is missing") String name) {
        return ResponseEntity.ok(matchService.getMatchInfo(name));
    }

    @Override
    public ResponseEntity<List<MatchResponseDto>> getUpcomingMatches() {
        return ResponseEntity.ok(matchService.getUpcomingMatches());
    }

    @Override
    public ResponseEntity<List<ClubResponseDto>> getAllClubs() {
        return ResponseEntity.ok(clubService.getAllClubsInfo());
    }

}
