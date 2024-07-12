package ita.compass.league.mapper;

import ita.compass.league.api.dto.*;
import ita.compass.league.model.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ClubMapper {
    public ClubResponseDto mapClubToClubResponseDto(Club club) {
        return ClubResponseDto.builder()
                .name(club.getName())
                .imageUrl(club.getImageUrl())
                .build();
    }

    public Club mapClubUploadDtoToClub(String imageUrl) {
        return Club.builder()
                .hostMatches(new ArrayList<>())
                .guestMatches(new ArrayList<>())
                .imageUrl(imageUrl)
                .build();
    }

}
