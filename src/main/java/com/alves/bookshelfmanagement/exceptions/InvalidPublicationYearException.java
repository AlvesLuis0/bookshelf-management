package com.alves.bookshelfmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPublicationYearException extends RuntimeException {

  public InvalidPublicationYearException(Integer publicationYear, Integer actualYear) {
    super("The publication year '%d' is not valid. Must be less then or equal to %d.".formatted(publicationYear, actualYear));
  }
  
}