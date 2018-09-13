package designpatterns;

public class Book implements Compare {

    private int length;

    public Book(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean largerThan(Compare other) {
        return this.length < ((Book) other).length;
    }

    @Override
    public String toString() {
        return "Book{" +
                "length=" + length +
                '}';
    }
}
