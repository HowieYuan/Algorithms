package sort.bubbleSort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 鸡尾酒排序/定向冒泡排序/搅拌排序
 * @date 2018-07-31
 * @time 11:20
 */
public class CocktailSort {
    public static int[] cocktailSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length / 2; i++) {
            boolean isSorted = true;
            for (int j = i; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    isSorted = false;
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
            if (isSorted) {
                break;
            }
            isSorted = true;
            for (int k = a.length - 2 - i; k > i; k--) {
                if (a[k] < a[k - 1]) {
                    isSorted = false;
                    temp = a[k - 1];
                    a[k - 1] = a[k];
                    a[k] = temp;
                }
            }
            if (isSorted) {
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1, 4, 5};
        System.out.println(Arrays.toString(cocktailSort(a)));
    }
}
