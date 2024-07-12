package ita.compass.league.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import ita.compass.league.api.dto.ClubResponseDto;
import ita.compass.league.api.dto.MatchResponseDto;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Tag(name = "ITA Soccer League Api")
@RequestMapping("/api/v1/")
public interface SoccerLeagueApi {

    @Operation(summary = "This service provides match info", description = "By passing in the appropriate options, you can find out info about specific match, \nMatch name is hostName_guestName, all lowercase")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Match response", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MatchResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Input"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @RequestMapping(
            value = "/match/{name}",
            produces = {"application/json"},
            method = RequestMethod.GET
    )
    ResponseEntity<MatchResponseDto> getMatch(@PathVariable @NotEmpty(message = "Field is missing") String name);

    @Operation(summary = "This service provides upcoming matches")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Upcoming matches response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MatchResponseDto.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Input"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @RequestMapping(
            value = "/match/upcoming",
            produces = {"application/json"},
            method = RequestMethod.GET
    )
    ResponseEntity<List<MatchResponseDto>> getUpcomingMatches();

    @Operation(summary = "This service provides all clubs list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Club response", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ClubResponseDto.class)))),
            @ApiResponse(responseCode = "400", description = "Bad Input"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @RequestMapping(
            value = "/club",
            produces = {"application/json"},
            method = RequestMethod.GET
    )
    ResponseEntity<List<ClubResponseDto>> getAllClubs();

}
