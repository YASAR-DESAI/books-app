package com.github.yasar.booksapp.repository;

import com.github.yasar.booksapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> getByYearAndAuthor(int year, String name);
}
