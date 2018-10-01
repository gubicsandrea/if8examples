package xml;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BookXmlHandler handler = new BookXmlHandler();
        List<Book> books = handler.loadFromClasspath();
        System.out.println(books);
        books.add(new Book("7845", "Egri csillagok", "Gárdonyi", 1984, false));
        books.remove(0);
        handler.saveBooksToClasspath(books);
    }
}
