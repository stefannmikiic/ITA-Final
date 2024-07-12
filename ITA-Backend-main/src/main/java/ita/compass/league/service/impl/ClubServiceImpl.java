package ita.compass.league.service.impl;

import ita.compass.league.api.dto.ClubResponseDto;
import ita.compass.league.mapper.ClubMapper;
import ita.compass.league.model.Club;
import ita.compass.league.repository.ClubRepository;
import ita.compass.league.service.ClubService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClubServiceImpl implements ClubService {

    private final ClubRepository clubRepository;
    private final ClubMapper clubMapper;

    @Override
    public List<ClubResponseDto> getAllClubsInfo() {
        List<Club> clubs = clubRepository.findAll();

        Comparator<ClubResponseDto> clubNameComparator = Comparator.comparing(ClubResponseDto::getName);

        List<ClubResponseDto> clubDtos = clubs.stream()
                .map(clubMapper::mapClubToClubResponseDto)
                .sorted(clubNameComparator)
                .toList();

        log.info("Fetched all clubs {}", clubDtos);
        return clubDtos;
    }

}
