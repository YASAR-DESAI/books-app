package com.github.yasar.booksapp.service;

import com.github.yasar.booksapp.model.Book;
import com.github.yasar.booksapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
       return bookService.getAllBooks();
    }

    @GetMapping("/books/secured")
    public List<Book> getAllBooksSecured(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getAllBooks(@PathVariable int id){
        return bookService.getBookById(id).orElse(null);
    }

    @DeleteMapping("/books")
    public void deleteBook(@RequestBody Book book){
        bookService.deleteBook(book);
    }

    @PostMapping("/books")
    public void saveBook(@RequestBody Book book){
        bookService.saveBook(book);
    }

    @PutMapping("/books")
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

    @PostMapping("/filter")
    public List<Book> getByYearAndAuthor(@RequestBody Book book){
        return bookService.getByYearAndAuthor(book.getYear(), book.getAuthor());
    }


}
