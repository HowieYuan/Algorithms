package sort.quickSort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 划分时从数组开头进行筛选，遇到小的元素，则往前面交换
 * @date 2018-10-17
 * @time 21:59
 */
public class QuickSort2 {
    public static void main(String[] args) {
        int[] nums = {3, 5, 1, 2, 7, 1};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int p, int q) {
        if (p >= q) {
            return;
        }
        int m = partition(nums, p, q);
        quickSort(nums, p, m - 1);
        quickSort(nums, m + 1, q);
    }

    /**
     * Lomuto 划分策略
     */
    private static int partition(int[] a, int low, int high) {
        int middle = low;
        for (int i = low; i < high; i++) {
            if (a[i] < a[high]) {
                if (i == middle) {
                    middle++;
                } else {
                    int temp = a[i];
                    a[i] = a[middle];
                    a[middle++] = temp;
                }
            }
        }
        int temp = a[high];
        a[high] = a[middle];
        a[middle] = temp;
        return middle;
    }
}
