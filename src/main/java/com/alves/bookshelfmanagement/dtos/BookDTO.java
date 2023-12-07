package com.alves.bookshelfmanagement.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BookDTO(

  @NotBlank(message = "The title field cannot be blank.")
  @Size(min = 3, max = 31, message = "The title value must be between 3 and 30 characters.")
  String title,
  @NotBlank(message = "The author field cannot be blank.")
  @Size(min = 3, max = 31, message = "The author value must be between 3 and 30 characters.")
  String author,
  @NotBlank(message = "The genre field cannot be blank.")
  @Size(min = 3, max = 31, message = "The genre value must be between 3 and 30 characters.")
  String genre,
  @NotNull(message = "The publication year field cannot be null.")
  Integer publicationYear

) {}