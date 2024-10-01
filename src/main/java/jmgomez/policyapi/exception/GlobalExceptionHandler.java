package jmgomez.policyapi.exception;

import feign.RetryableException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiException badRequestException(BadRequestException e) {
        log.error("Bad Request Exception", e.getMessage(), e);
        return new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of(String.valueOf(ZoneOffset.UTC))));
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiException notFoundException(NotFoundException e) {
        log.error("Not Found Exception", e.getMessage(), e);
        return new ApiException(e.getMessage(), HttpStatus.NOT_FOUND, ZonedDateTime.now(ZoneId.of(String.valueOf(ZoneOffset.UTC))));
    }

    @ExceptionHandler({RuntimeException.class, Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiException internalServerError(RuntimeException e) {
        log.error("Internal Server Error Exception", e.getMessage(), e);
        return new ApiException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, ZonedDateTime.now(ZoneId.of(String.valueOf(ZoneOffset.UTC))));
    }

    @ExceptionHandler({RetryableException.class, ServiceUnavailableException.class})
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ResponseBody
    public ApiException serviceUnavailableException(ServiceUnavailableException e) {
        log.error("Retryable Exception", e.getMessage(), e);
        return new ApiException(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE, ZonedDateTime.now(ZoneId.of(String.valueOf(ZoneOffset.UTC))));
    }
}
