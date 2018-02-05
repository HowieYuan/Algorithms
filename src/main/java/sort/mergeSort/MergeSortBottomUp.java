package sort.mergeSort;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 自底向上的归并排序
 * @date 2018-02-01
 * @time 21:29
 */
@SuppressWarnings("Duplicates")
public class MergeSortBottomUp {
    /**
     * 归并排序
     */
    public int[] mergeSort(int[] a) {
        if (a.length == 0 || a.length == 1) {
            return a;
        }
        int[] temp = new int[a.length];
        int n = a.length;
        for (int i = 1; i <= n; i *= 2) {
            for (int j = 0; j < n - i; j += 2 * i) {
                merge(a, temp, j, j + i - 1, Math.min(j + 2 * i - 1, n - 1));
            }
        }
        return a;
    }

    /**
     * 归并
     */
    private static void merge(int[] a, int[] temp, int low, int mid, int high) {
        System.arraycopy(a, low, temp, low, high + 1 - low);
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
