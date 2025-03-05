package skontra.book_cloud.utils;

import skontra.book_cloud.domain.Book;

import java.util.ArrayList;

public class InMemoryDatabase {

    private static final ArrayList<Book> books = new ArrayList<>();
    private static int idCounter = 0;

    public static void init() {
        addBook("Harry Potter", 234, "KJ Rowling");
        addBook("Atomic Habits", 151, "Mister Due");
        addBook("Masterpiece", 734, "Namo Sali");
    }

    public static void addBook(String name, int numOfPages, String author) {
        books.add(new Book(idCounter, name, numOfPages, author));
        idCounter++;
    }

    public static void deleteBook(String name) throws Exception {
        var deletingBook = books.stream().filter(book -> name.equals(book.getName())).findFirst();
        if (deletingBook.isPresent()) {
            books.remove(deletingBook.get());
        } else {
            throw new Exception("Invalid book name");
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return books;
    }
}

