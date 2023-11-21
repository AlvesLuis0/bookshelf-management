package com.alves.bookshelfmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alves.bookshelfmanagement.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {}