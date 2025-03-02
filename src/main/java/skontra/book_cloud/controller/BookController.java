package skontra.book_cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import skontra.book_cloud.domain.Book;

@Controller
@SessionAttributes("book")
public class BookController {

    @GetMapping("/")
    private String home() {
        return "landing";
    }

    @GetMapping("/books")
    private String books() {
        return "books";
    }

    @ModelAttribute(name = "book")
    public Book book() {
        return new Book("Harry Potter", 123);
    }
}
