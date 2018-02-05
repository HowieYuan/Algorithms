package sort.insertion;

import util.ArrayUtil;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 插入排序
 * @date 2018-02-05
 * @time 21:59
 */
public class InsertionSort {
    /**
     * 插入排序
     */
    int[] insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                ArrayUtil.swap(a, j, j - 1);
            }
        }
        return a;
    }

    /**
     * 不需要数据交换的插入排序
     */
    int[] insertionSortWithoutExchange(int[] a) {
        int temp, j;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            for (j = i; j > 0 && temp < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }
        return a;
    }
}
