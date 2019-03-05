package sort.selection;

import util.ArrayUtil;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description
 * @date 2018-03-05
 * @time 22:42
 */
public class HeapSort {
    public static void main(String[] args) {
        HeapSort sort = new HeapSort();
        int[] a = new int[]{3, 4, 1, 6, 5, 2};
        System.out.println(Arrays.toString(sort.sort(a)));
    }

    /**
     * 堆排序
     *
     * @param a 待排数组
     */
    public int[] sort(int[] a) {
        int n = a.length;
        int k = n / 2;
        while (k > 0) {
            //通过多次的下沉操作，建大顶堆
            sink(k--, n, a);
        }
        while (n > 1) {
            ArrayUtil.swap(a, 0, n - 1);
            //通过多次下沉操作，依次取得当前最大值
            sink(1, --n, a);
        }
        return a;
    }

    /**
     * 由上而下的堆有序化（下沉）
     *
     * @param k 待下沉的堆结点的位置
     * @param n 堆最末位结点的位置
     * @param a 待排数组（堆）
     */
    private void sink(int k, int n, int[] a) {
        while (k * 2 <= n) {
            int j = k * 2;
            //由于堆的根结点序号为 1，类比到数组下标时需要将位序自减 1,
            if (j < n && a[j - 1] < a[j]) {
                j++;
            }
            //位序减一
            if (a[k - 1] >= a[j - 1]) {
                break;
            }
            //位序减一
            ArrayUtil.swap(a, k - 1, j - 1);
            k = j;
        }
    }

    /**
     * 若令堆的根结点为 0，那么可以使堆和数组的位序一一对应
     * 而下沉方法需要作一些改变
     */
    public int[] sort2(int[] a) {
        int n = a.length - 1;
        int k = n / 2;
        while (k >= 0) {
            sinkStartInZero(k--, n, a);
        }
        while (n > 0) {
            ArrayUtil.swap(a, 0, n);
            sinkStartInZero(0, --n, a);
        }
        return a;
    }

    private void sinkStartInZero(int k, int n, int[] a) {
        while ((k + 1) * 2 <= n) {
            int j = k * 2 + 1;
            if (j < n && a[j] < a[j + 1]) {
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
