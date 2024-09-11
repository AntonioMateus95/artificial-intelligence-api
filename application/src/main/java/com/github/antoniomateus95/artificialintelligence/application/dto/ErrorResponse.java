package com.github.antoniomateus95.artificialintelligence.application.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponse {

  private String error;
  private String message;

  public ErrorResponse(HttpStatus status, String message) {
    this.error = status.getReasonPhrase();
    this.message = message;
  }
}
