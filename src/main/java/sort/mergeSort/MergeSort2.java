package sort.mergeSort;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description
 * @date 2018-10-17
 * @time 16:07
 */
public class MergeSort2 {
    private static int[] sort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void mergeSort(int[] nums, int p, int q) {
        if (p >= q) {
            return;
        }
        int r = (q + p) / 2;
        mergeSort(nums, p, r);
        mergeSort(nums, r + 1, q);
        merge(nums, p, r, q);
    }

    private static void merge(int[] nums, int p, int r, int q) {
        int i = p, j = r + 1, n = 0;
        //临时空间
        int[] temp = new int[q - p + 1];
        while (i <= r && j <= q) {
            if (nums[i] < nums[j]) {
                temp[n++] = nums[i++];
            } else {
                temp[n++] = nums[j++];
            }
        }
        while (i <= r) {
            temp[n++] = nums[i++];
        }
        while (j <= q) {
            temp[n++] = nums[j++];
        }
        //复制回原数组
        for (int num : temp) {
            nums[p++] = num;
        }
    }
}
