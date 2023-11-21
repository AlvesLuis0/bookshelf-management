package com.alves.bookshelfmanagement.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alves.bookshelfmanagement.dtos.BookDTO;
import com.alves.bookshelfmanagement.models.Book;
import com.alves.bookshelfmanagement.services.BookService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController @RequiredArgsConstructor
public class BookController {

  private final BookService bookService;

  @GetMapping
  public ResponseEntity<List<Book>> findAll() {
    return ResponseEntity.status(HttpStatus.OK).body(bookService.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> findById(@PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
  }

  @PostMapping
  public ResponseEntity<Book> create(@RequestBody @Valid BookDTO book) {
    return ResponseEntity.status(HttpStatus.CREATED).body(bookService.create(book));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> updateById(@RequestBody @Valid BookDTO book, @PathVariable Integer id) {
    return ResponseEntity.status(HttpStatus.OK).body(bookService.updateByID(book, id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
    bookService.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
  
}