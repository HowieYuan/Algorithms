package sort.quickSort;

import util.ArrayUtil;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 三向切分的快排
 * @date 2018-02-05
 * @time 21:21
 */
public class QuickSortThreeWayCut {
    public int[] quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
        return a;
    }

    /**
     * 三向切分
     */
    private void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int lt = low, gt = high, i = low + 1;
        int value = a[low];
        while (i <= gt) {
            if (a[i] < value) {
                ArrayUtil.swap(a, i, lt);
                i++;
                lt++;
            } else if (a[i] > value) {
                ArrayUtil.swap(a, i, gt);
                gt--;
            } else {
                i++;
            }
        }
        quickSort(a, low, lt - 1);
        quickSort(a, gt + 1, high);
    }
}
