package skontra.book_cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import skontra.book_cloud.domain.Book;

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
        return mav;
    }

    @PostMapping("/books")
    private String bookAdded(Model model, @RequestParam("name") String name, @RequestParam("pages") int numOfPages) throws InterruptedException {
        log.info("Sending data: " + name);
        ModelAndView mav = new ModelAndView("book-added");
        model.addAttribute("book", new Book(name, numOfPages));
        Thread.sleep(1000); // simulate a slow database
        return "book-added";
    }
}
