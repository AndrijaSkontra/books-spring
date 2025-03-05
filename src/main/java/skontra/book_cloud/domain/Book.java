package skontra.book_cloud.domain;

import lombok.Data;

@Data
public class Book {
    private final int id;
    private final String name;
    private final int numOfPages;
    private final String author;
}
