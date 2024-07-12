package ita.compass.league.service;

import ita.compass.league.api.dto.ClubResponseDto;

import java.util.List;

public interface ClubService {
    List<ClubResponseDto> getAllClubsInfo();
}
