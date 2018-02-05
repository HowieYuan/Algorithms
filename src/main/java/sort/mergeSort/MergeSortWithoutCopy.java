package sort.mergeSort;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 改进版归并排序
 *              利用 k 值的奇偶性来交换输入数组和辅助数组的角色，节省数组的复制
 * @date 2018-02-01
 * @time 16:31
 */
@SuppressWarnings("Duplicates")
public class MergeSortWithoutCopy {
    /**
     * 归并排序
     */
    public int[] mergeSort(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return a;
        }
        int[] temp = new int[a.length];
        toMergeSortWithoutCopy(a, temp, 0, a.length - 1, 0);
        return a;
    }

    /**
     * 不需要将元素复制到辅助数组的归并排序
     *
     * @param a    待排序列
     * @param a2   辅助空间
     * @param low  当前子序列首项位序
     * @param high 当前子序列末项位序
     * @param k    辅助值，根据当前 k 的值决定 a 与 a2 的归并
     */
    private static void toMergeSortWithoutCopy(int[] a, int[] a2, int low, int high, int k) {
        if (low == high) {
            // k 值为奇数，将值赋到 a2
            if (k % 2 == 1) {
                a2[low] = a[low];
            }
            return;
        }
        int mid = (high - low) / 2 + low;
        toMergeSortWithoutCopy(a, a2, low, mid, k + 1);
        toMergeSortWithoutCopy(a, a2, mid + 1, high, k + 1);
        // k 值为奇数，归并到 a2，否则归并到 a
        if (k % 2 == 1) {
            mergeWithoutCopy(a, a2, low, high);
        } else {
            mergeWithoutCopy(a2, a, low, high);
        }
    }

    /**
     * 不需要将元素复制到辅助数组的归并
     * b 归并到 a
     */
    private static void mergeWithoutCopy(int[] b, int[] a, int low, int high) {
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
