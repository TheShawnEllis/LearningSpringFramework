package learning.springframework.spring5webapp.controllers;

import learning.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// LEARNING: @Controller annotation is used to mark the class as a Spring MVC Controller
@Controller
public class BookController {

    private final BookRepository bookRepository;

    // LEARNING: The constructor is added to inject the BookRepository into the BookController
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // LEARNING: @RequestMapping annotation is used to map web requests onto specific controller handler classes or handler methods
    @RequestMapping("/books")
    public String getBooks(Model model) {

        // LEARNING: The model is added so that at run time when the URL "/books" is hit
        //  The model will be populated with an iterable using the repository of list of books
        //  ThymeLeaf will use this iterable object in the html file
        model.addAttribute("books", bookRepository.findAll());

        return "books/list";
    }
}
