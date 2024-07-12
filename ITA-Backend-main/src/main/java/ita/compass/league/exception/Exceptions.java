package ita.compass.league.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public interface Exceptions {
    class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }

        public ResourceNotFoundException() {
            super("Requested resource not found");
        }
    }

    class BadRequestException extends RuntimeException {
        public BadRequestException(String message) {
            super(message);
        }

        public BadRequestException() {
            super("Bad Request");
        }
    }

    class FailedToSaveException extends RuntimeException {
        public FailedToSaveException(String message) {
            super(message);
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    class ExceptionResponse {
        private HttpStatus httpStatus;
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
        private LocalDateTime timestamp;
        private String message;
    }
}
