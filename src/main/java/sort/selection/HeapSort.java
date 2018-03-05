package sort.selection;

import util.ArrayUtil;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description
 * @date 2018-03-05
 * @time 22:42
 */
public class HeapSort {


    private void sink(int k, int n, int[] a) {
        while (k * 2 <= n) {
            int j = k * 2;
            if (a[j] < a[j + 1]) {
                j++;
            }
            if (a[k] >= a[j]) {
                break;
            }
            ArrayUtil.swap(a, k, j);
            k = j;
        }
    }
}
