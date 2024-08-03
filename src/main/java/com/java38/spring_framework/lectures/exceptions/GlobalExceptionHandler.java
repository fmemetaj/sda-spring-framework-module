package com.java38.spring_framework.lectures.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SdaException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handleSdaException(SdaException e) {
        log.error("SdaException occurred", e);
        return new Error(e.getMessage());
    }

    @ExceptionHandler(SpecificSdaException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Error handleSpecificSdaException(SpecificSdaException e) {
        log.error("SpecificSdaException occurred", e);
        return new Error(e.getMessage());
    }
}
