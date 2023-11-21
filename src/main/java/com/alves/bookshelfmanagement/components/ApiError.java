package com.alves.bookshelfmanagement.components;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;

@Data
public class ApiError {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
  private OffsetDateTime timestamp;
  private Integer status;
  private String error;
  private Object message;
  private String path;

  public ApiError(HttpStatus status, Object message, HttpServletRequest request) {
    this.timestamp = OffsetDateTime.now();
    this.status = status.value();
    this.error = status.getReasonPhrase();
    this.message = message;
    this.path = request.getRequestURI();
  }
  
}