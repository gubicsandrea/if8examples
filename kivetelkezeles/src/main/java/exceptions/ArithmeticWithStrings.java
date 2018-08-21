package exceptions;

public class ArithmeticWithStrings {

    int add(String a, String b) {
        if (a == null || b == null) {
            throw new NullPointerException("a and b cannot be null");
        }
        if (a.trim().isEmpty() || b.trim().isEmpty()) {
            throw new IllegalArgumentException("a and b cannot be empty");
        }
        try {
            int x = Integer.parseInt(a);
            int y = Integer.parseInt(b);
            return x + y;
        } catch (NumberFormatException nfex) {
            throw new IllegalArgumentException("Parameters are not valid integers", nfex);
        } catch (IllegalArgumentException iaex) {
            System.out.println("hiba");
            return 0;
        } finally {
            System.out.println("Finally");
        }
    }
}
