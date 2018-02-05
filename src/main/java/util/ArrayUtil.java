package util;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description
 * @date 2018-02-05
 * @time 21:56
 */
public class ArrayUtil {
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void insertSort(int[] a, int low, int high) {
        int n, j;
        for (int i = low + 1; i <= high; i++) {
            n = a[i];
            for (j = i; j > low && n < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = n;
        }
    }
}
