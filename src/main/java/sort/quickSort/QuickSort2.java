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

    private static int partition(int[] nums, int p, int q) {
        int i = p, j = p;
        for (;j < q; j++) {
            if (nums[j] < nums[q]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
        int temp = nums[i];
        nums[i] = nums[q];
        nums[q] = temp;
        return i;
    }
}
