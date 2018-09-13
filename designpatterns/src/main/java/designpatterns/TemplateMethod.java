package designpatterns;

public class TemplateMethod {

    public void sort(Object[] arr, Interchangable interchangable) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (interchangable.needToInterchange(arr[i], arr[j])) {
                    Object q = arr[i];
                    arr[i] = arr[j];
                    arr[j] = q;
                }
            }
        }
    }

    public void sort(Compare[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].largerThan(arr[j])) {
                    Compare q = arr[i];
                    arr[i] = arr[j];
                    arr[j] = q;
                }
            }
        }
    }
}
