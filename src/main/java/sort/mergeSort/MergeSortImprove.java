package sort.mergeSort;

import util.ArrayUtil;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 改进版归并排序：
 *              1. 小规模数组使用插入排序
 *              2. 如果子数组已经有序，则跳过归并方法的改进
 *              3. 通过传入数组参数的交换达到节省数组复制的目的
 * @date 2018-02-01
 * @time 16:41
 */
@SuppressWarnings("Duplicates")
public class MergeSortImprove {
    /**
     * 归并排序
     */
    public int[] mergeSort(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return a;
        }
        //开始排序前，将 a 复制到 b
        int[] b = a.clone();
        toMergeSort(a, b, 0, a.length - 1);
        return a;
    }

    /**
     *  排序
     */
    private void toMergeSort(int[] a, int[] b, int low, int high) {
        if (high - low + 1 < 15) {
            //如果是小规模子数组，使用插入排序
            ArrayUtil.insertSort(a, low, high);
        } else {
            //归并
            int mid = (high - low) / 2 + low;
            toMergeSort(b, a, low, mid);
            toMergeSort(b, a, mid + 1, high);
            //a[mid] <= a[mid + 1] 说明子数组已经有序
            // 无需接下来的 merge 方法归并，直接复制到原数组
            if (b[mid] <= b[mid + 1]) {
                System.arraycopy(b, low, a, low, high - low + 1);
                return;
            }
            merge(b, a, low, high);
        }
    }

    /**
     * 归并
     * b 归并到 a
     */
    private static void merge(int[] b, int[] a, int low, int high) {
        int mid = (high - low) / 2 + low;
        int i = low;
        int j = mid + 1;
        for (int k = low; k < high + 1; k++) {
            if (i > mid) {
                a[k] = b[j++];
            }
            //这里的 if 必须加 else
            // 因为上一个 a[k] = temp[j++]; 中 j 自增了 1，可能会导致这里溢出
            else if (j > high) {
                a[k] = b[i++];
            }
            //下面两个if加else不用多说
            else if (b[i] <= b[j]) {
                a[k] = b[i++];
            } else {
                a[k] = b[j++];
            }
        }
    }
}
