package skontra.book_cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import skontra.book_cloud.utils.InMemoryDatabase;

@SpringBootApplication
public class BookCloudApplication {

    public static void main(String[] args) {
        InMemoryDatabase.init();
        SpringApplication.run(BookCloudApplication.class, args);
    }

}
