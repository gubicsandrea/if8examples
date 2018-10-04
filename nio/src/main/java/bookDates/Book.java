package bookDates;

import java.time.LocalDate;

public class Book {

    private String author;
    private String title;
    private LocalDate publishDate;

    public Book(String author, String title, LocalDate publishDate) {
        this.author = author;
        this.title = title;
        this.publishDate = publishDate;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }
}
