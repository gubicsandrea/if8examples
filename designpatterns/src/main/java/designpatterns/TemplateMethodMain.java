package designpatterns;

import java.util.Arrays;

public class TemplateMethodMain {

    public static void main(String[] args) {
        Book[] books = {new Book(23), new Book(16), new Book(21)};

        TemplateMethod templateMethod = new TemplateMethod();

        templateMethod.sort(books);

        System.out.println(Arrays.toString(books));
    }
}
