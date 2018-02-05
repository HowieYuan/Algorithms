package sort.selection;

import util.ArrayUtil;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 简单选择排序
 * @date 2018-02-05
 * @time 21:55
 */
public class SelectionSort {
    int[] selectionSort(int[] a) {
        int min;
        for (int i = 0; i < a.length; i++) {
            min = i;
            //选择
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            //交换
            ArrayUtil.swap(a, i, min);
        }
        return a;
    }
}
