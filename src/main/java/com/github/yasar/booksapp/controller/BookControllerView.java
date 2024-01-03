package com.github.yasar.booksapp.controller;

import com.github.yasar.booksapp.model.Book;
import com.github.yasar.booksapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class BookControllerView {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String viewHomePage(Model model){
            model.addAttribute("listBooks", bookService.getAllBooks());
            return "index";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model){
        Book book =  new Book();
        model.addAttribute("book", book);

        return "showNewBookForm";
    }


    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book){
        bookService.saveBook(book);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable int id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book",book);
        return "updateBook";
    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id, Model model){
        Book book = bookService.getBookById(id);
        bookService.deleteBook(book);
        return "redirect:/";
    }
}
