package ita.compass.league.service;

import ita.compass.league.api.dto.MatchResponseDto;

import java.util.List;

public interface MatchService {
    MatchResponseDto getMatchInfo(String name);
    List<MatchResponseDto> getUpcomingMatches();
}
