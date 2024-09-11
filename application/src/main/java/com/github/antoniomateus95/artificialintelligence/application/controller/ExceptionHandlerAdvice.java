package com.github.antoniomateus95.artificialintelligence.application.controller;

import com.github.antoniomateus95.artificialintelligence.application.dto.ErrorResponse;
import com.github.antoniomateus95.artificialintelligence.domain.exception.InvalidProviderTypeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerAdvice {

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(InvalidProviderTypeException.class)
  public ErrorResponse handleInvalidProviderTypeException(InvalidProviderTypeException exception) {
    log.error("Exception thrown: InvalidProviderTypeException", exception);
    return new ErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
  }
}
