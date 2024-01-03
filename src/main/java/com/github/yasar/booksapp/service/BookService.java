package com.github.yasar.booksapp.service;

import com.github.yasar.booksapp.model.Book;
import com.github.yasar.booksapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getAllBooks(){
       return bookRepository.findAll();
    }

    public Optional<Book> findBookById(int id){
        return bookRepository.findById(id);
    }

    public void deleteBook(Book book){
        bookRepository.delete(book);
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }
    public List<Book> getByYearAndAuthor(int year, String name){
        return bookRepository.getByYearAndAuthor(year, name);
    }

    public Book getBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent())
            return book.get();

        System.out.printf("No Book with id {} found",id);
        throw  new NotFoundException("No Book Found!!");
    }
}
