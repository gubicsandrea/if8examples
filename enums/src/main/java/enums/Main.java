package enums;

public class Main {

    public static void main(String[] args) {
        Days day = Days.MONDAY;
        day = day.next();
        System.out.println(day);
    }
}
