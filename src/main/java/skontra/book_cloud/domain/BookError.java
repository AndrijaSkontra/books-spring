package skontra.book_cloud.domain;

import lombok.Data;

@Data
public class BookError {
    private String nameError = "";
    private String numOfPagesError = "";
}
