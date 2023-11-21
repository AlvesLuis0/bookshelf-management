package com.alves.bookshelfmanagement.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alves.bookshelfmanagement.components.ApiError;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ErrorController {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ApiError handleValidationExceptions(MethodArgumentNotValidException exception, HttpServletRequest request) {
    Map<String, String> errors = new HashMap<>();
    exception.getBindingResult().getAllErrors().forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String errorMessage = error.getDefaultMessage();
      errors.put(fieldName, errorMessage);
    });
    return new ApiError(HttpStatus.BAD_REQUEST, errors, request);
  }

}