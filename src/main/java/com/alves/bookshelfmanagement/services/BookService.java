package com.alves.bookshelfmanagement.services;

import java.time.Year;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.alves.bookshelfmanagement.dtos.BookDTO;
import com.alves.bookshelfmanagement.exceptions.BookNotFoundException;
import com.alves.bookshelfmanagement.exceptions.InvalidPublicationYearException;
import com.alves.bookshelfmanagement.models.Book;
import com.alves.bookshelfmanagement.repositories.BookRepository;

import lombok.RequiredArgsConstructor;

@Service @RequiredArgsConstructor
public class BookService {

  private final BookRepository bookRepository;

  public List<Book> findAll() {
    return bookRepository.findAll();
  }

  public Book create(BookDTO book) {
    checkPublicationYear(book.publicationYear());
    Book newBook = new Book();
    BeanUtils.copyProperties(book, newBook);
    return bookRepository.save(newBook);
  }

  public Book updateByID(BookDTO book, Integer id) {
    if(!bookRepository.existsById(id)) {
      throw new BookNotFoundException(id);
    }
    checkPublicationYear(book.publicationYear());
    Book updatedBook = new Book();
    BeanUtils.copyProperties(book, updatedBook);
    updatedBook.setId(id);
    return bookRepository.save(updatedBook);
  }

  public Book findById(Integer id) {
    return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
  }

  public void deleteById(Integer id) {
    Book book = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    bookRepository.delete(book);
  }

  private void checkPublicationYear(Integer publicationYear) {
    Integer actualYear = Year.now().getValue();
    if(publicationYear > actualYear) {
      throw new InvalidPublicationYearException(publicationYear, actualYear);
    }
  }
  
}