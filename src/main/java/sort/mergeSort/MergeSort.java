package sort.mergeSort;

import util.ArrayUtil;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 普通自顶向下归并排序
 * 以及
 * 小规模数组使用插入排序和如果子数组已经有序，则跳过归并方法的改进
 * @date 2018-02-01
 * @time 16:27
 */
@SuppressWarnings("Duplicates")
public class MergeSort {
    /**
     * 归并排序
     */
    public int[] mergeSort(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return a;
        }
        int[] temp = new int[a.length];
        toMergeSort(a, temp, 0, a.length - 1);
        return a;
    }

    /**
     * 排序
     *
     * @param a    待排序列
     * @param temp 临时辅助空间
     * @param low  当前子序列首项位序
     * @param high 当前子序列末项位序
     */
    private static void toMergeSort(int[] a, int[] temp, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (high - low) / 2 + low;
        toMergeSort(a, temp, low, mid);
        toMergeSort(a, temp, mid + 1, high);
        if (a[mid] <= a[mid + 1]) {
            return;
        }
        merge(a, temp, low, high);
    }

    /**
     * 改进归并排序 ：
     * 1.如果是小规模数组，使用插入排序
     * 2.如果子数组已经有序，则跳过归并方法
     * 通过第二点的改进，处理一个已经有序的数组所需要的比较次数是线性级别的
     */
    private void toMergeSortImprove(int[] a, int[] temp, int low, int high) {
        if (high - low + 1 < 15) {
            //如果是小规模子数组，使用插入排序
            ArrayUtil.insertSort(a, low, high);
        } else {
            //对大规模数组进行归并
            int mid = (high - low) / 2 + low;
            toMergeSortImprove(a, temp, low, mid);
            toMergeSortImprove(a, temp, mid + 1, high);
            //a[mid] <= a[mid + 1] 说明子数组已经有序，无需接下来的 merge 方法归并，直接跳过
            if (a[mid] <= a[mid + 1]) {
                return;
            }
            merge(a, temp, low, high);
        }
    }

    /**
     * 归并
     */
    private static void merge(int[] a, int[] temp, int low, int high) {
        //复制数组到辅助数组
        System.arraycopy(a, low, temp, low, high + 1 - low);
        int mid = (high - low) / 2 + low;
        int i = low;
        int j = mid + 1;
        for (int k = low; k < high + 1; k++) {
            if (i > mid) {
                a[k] = temp[j++];
            }
            //这里的 if 必须加 else
            // 因为上一个 a[k] = temp[j++]; 中 j 自增了 1，可能会导致这里溢出
            else if (j > high) {
                a[k] = temp[i++];
            }
            //下面两个if加else不用多说
            else if (temp[i] <= temp[j]) {
                a[k] = temp[i++];
            } else {
                a[k] = temp[j++];
            }
        }
    }
}
