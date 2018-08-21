package rekurzio;

public class Factorial {

    public int fakt(int n) {
        int result = 1;
        for (int i = n; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public int fatWithRecursion(int n) {
        if(n == 0 || n == 1) {
            return 1;
        }
        return fatWithRecursion(n - 1) * n;
    }
}
