package ita.compass.league.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class ExceptionHandlerController {
    @ExceptionHandler
    public ResponseEntity<Exceptions.ExceptionResponse> resourceNotFoundException(Exceptions.ResourceNotFoundException exception) {
        return prepareResponse(HttpStatus.NOT_FOUND, exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<Exceptions.ExceptionResponse> badRequestException(Exceptions.BadRequestException exception) {
        return prepareResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<Exceptions.ExceptionResponse> failedToSaveException(Exceptions.FailedToSaveException exception) {
        return prepareResponse(HttpStatus.NOT_MODIFIED, exception.getMessage());
    }

    private ResponseEntity<Exceptions.ExceptionResponse> prepareResponse(HttpStatus status, String message) {
        Exceptions.ExceptionResponse response = new Exceptions.ExceptionResponse(status, LocalDateTime.now(), message);
        log.info("Exception: {}", response);
        return ResponseEntity.status(status).body(response);
    }
}
