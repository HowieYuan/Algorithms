package sort.bubbleSort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 冒泡排序
 * @date 2018-07-31
 * @time 11:10
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    /**
     * 添加 isSorted 判断的优化版本
     */
    public static int[] bubbleSort2(int[] a) {
        int temp;
        for (int i = 0; i < a.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
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
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {0, 2, 1, 3, 4, 6, 4, 1, 1, 9};
        System.out.println(Arrays.toString(bubbleSort(a)));
    }
}
