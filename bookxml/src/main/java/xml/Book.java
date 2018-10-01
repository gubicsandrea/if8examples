package xml;

public class Book {

    private String isbn;
    private String title;
    private String author;
    private int yearOfPublish;
    private boolean available;
    private int limit;

    public Book(String isbn, String title, String author, int yearOfPublish, boolean available) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.available = available;
    }

    public Book(String isbn, String title, String author, int yearOfPublish, boolean available, int limit) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.available = available;
        this.limit = limit;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public boolean isAvailable() {
        return available;
    }

    public int getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        if (limit == 0) {
            return "Book{" +
                    "isbn='" + isbn + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", yearOfPublish=" + yearOfPublish +
                    ", available=" + available +
                    '}';
        } else {
            return "Book{" +
                    "isbn='" + isbn + '\'' +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", yearOfPublish=" + yearOfPublish +
                    ", available=" + available +
                    ", limit=" + limit +
                    '}';
        }
    }
}
