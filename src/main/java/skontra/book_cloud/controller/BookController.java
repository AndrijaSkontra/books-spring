package skontra.book_cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import skontra.book_cloud.utils.InMemoryDatabase;

@Slf4j
@Controller
public class BookController {

//    @GetMapping("/")
//    private String home() {
//        return "hello world";
//    }

    @GetMapping("/books")
    private ModelAndView books() {
        ModelAndView mav = new ModelAndView("mpa/index");
        mav.addObject("books", InMemoryDatabase.getAllBooks());
        return mav;
    }

//    @PostMapping("/books")
//    private ModelAndView bookAdded(@RequestParam("name") String name, @RequestParam("pages") String numOfPages, @RequestParam("author") String author) throws InterruptedException {
//        ModelAndView mav = new ModelAndView("book-added");
//        try {
//            if (name.isEmpty()) {
//                throw new InvalidInputException("Please input the name!");
//            }
//            var numOfPagesStr = Integer.parseInt(numOfPages);
//            mav.addObject("book", new Book(name, numOfPagesStr, author));
//        } catch (NumberFormatException ex) {
//            var bookError = new BookError();
//            bookError.setNumOfPagesError("Invalid Pages Inserted");
//            mav.addObject("error", bookError);
//            mav.addObject("book", new Book(name, 0, author));
//        } catch (InvalidInputException ex) {
//            var bookError = new BookError();
//            bookError.setNameError("Invalid Book Name");
//            mav.addObject("error", bookError);
//            var numOfPagesStr = Integer.parseInt(numOfPages);
//            mav.addObject("book", new Book("Invalid Name", numOfPagesStr, author));
//        }
//        Thread.sleep(1000); // simulate a slow database
//        return mav;
//    }
}
