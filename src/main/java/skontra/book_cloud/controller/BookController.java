package skontra.book_cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import skontra.book_cloud.domain.Book;
import skontra.book_cloud.domain.BookError;

@Slf4j
@Controller
public class BookController {

    @GetMapping("/")
    private String home() {
        return "landing";
    }

    @GetMapping("/books")
    private ModelAndView books() {
        ModelAndView mav = new ModelAndView("books");
        mav.addObject("book", new Book("Harry smolder", 324));
        mav.addObject("error", new BookError());
        return mav;
    }

    @PostMapping("/books")
    private ModelAndView bookAdded(@RequestParam("name") String name, @RequestParam("pages") String numOfPages) throws InterruptedException {
        ModelAndView mav = new ModelAndView("book-added");
        try {
            mav.addObject("book", new Book(name, Integer.parseInt(numOfPages)));
        } catch (NumberFormatException ex) {
            var bookError = new BookError();
            bookError.setNameError("Invalid Book Name");
            bookError.setNumOfPagesError("Invalid Pages Inserted");
            // fixme: this doesn't work because im returning the error object onto the book-added,
            // but I need the error in the book.html
            mav.addObject("error", bookError);
            mav.addObject("book", new Book("", 0));
        }
        Thread.sleep(1000); // simulate a slow database
        return mav;
    }
}
