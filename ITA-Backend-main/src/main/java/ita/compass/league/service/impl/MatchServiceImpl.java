package ita.compass.league.service.impl;

import ita.compass.league.api.dto.MatchResponseDto;
import ita.compass.league.exception.Exceptions;
import ita.compass.league.mapper.MatchMapper;
import ita.compass.league.model.Match;
import ita.compass.league.repository.MatchRepository;
import ita.compass.league.service.MatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static ita.compass.league.util.DateUtil.dateFromString;

@Service
@RequiredArgsConstructor
@Slf4j
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;

    @Override
    public MatchResponseDto getMatchInfo(String name) {
        Match match = matchRepository.findByName(name)
                .orElseThrow(() -> new Exceptions.ResourceNotFoundException("Match not found"));

        log.info("Fetched match {}", match);
        return matchMapper.mapMatchToMatchResponseDto(match);
    }

    @Override
    public List<MatchResponseDto> getUpcomingMatches() {
        LocalDateTime nowDateTime = LocalDateTime.now();
        List<Match> matches = matchRepository.findAll().stream()
                .filter(match -> !dateFromString(match.getDate()).isBefore(nowDateTime))
                .toList();

        List<MatchResponseDto> matchesDto = matches.stream()
                .map(matchMapper::mapMatchToMatchResponseDto)
                .toList();

        log.info("Fetched upcoming matches {}", matchesDto);
        return matchesDto;
    }

}
