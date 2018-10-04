package bookDates;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("King", "Az", LocalDate.of(2003, 10, 4)),
                new Book("Gárdonyi", "Egri csillagok", LocalDate.of(1984, 2, 12)),
                new Book("Weeks", "Lightbringer", LocalDate.of(2017, 12, 4)),
                new Book("Jókai", "Aranyember", LocalDate.of(1984, 2, 12)),
                new Book("Wells", "Időgép", LocalDate.of(1885, 01, 26))
        );

        List<Book> empty = new ArrayList<>();

        List<Book> small = Arrays.asList(new Book("Weeks", "Lightbringer", LocalDate.of(2017, 12, 4)));

        Main m = new Main();
        System.out.println(m.getFirstPublishedAuthors(small));
        System.out.println(m.getFirstPublishedAuthors2(small));
    }

    public List<String> getFirstPublishedAuthors(List<Book> books) {
        List<Book> copyBooks = new ArrayList<>(books);
        Collections.sort(copyBooks, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getPublishDate().compareTo(b2.getPublishDate());
            }
        });
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < copyBooks.size() && i < 3) {
            result.add(copyBooks.get(i).getAuthor());
            i++;
        }
        return result;
    }

    public List<String> getFirstPublishedAuthors2(List<Book> books) {
        return books.stream()
                .sorted(Comparator.comparing(Book::getPublishDate))
                .limit(3)
                .map(b -> b.getAuthor())
                .collect(Collectors.toList());
    }
}
