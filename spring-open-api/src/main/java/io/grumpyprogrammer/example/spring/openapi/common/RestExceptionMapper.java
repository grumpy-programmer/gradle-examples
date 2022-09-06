package io.grumpyprogrammer.example.spring.openapi.common;

import io.grumpyprogrammer.example.spring.openapi.api.dto.NotFoundError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.OffsetDateTime;

@ControllerAdvice
public class RestExceptionMapper {

    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<NotFoundError> notFoundError(NotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        NotFoundError error = new NotFoundError()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .error(status.getReasonPhrase())
                .message(e.getMessage())
                .path(request.getRequestURI())
                .id(e.getId());


        return ResponseEntity.status(status).body(error);
    }
}
