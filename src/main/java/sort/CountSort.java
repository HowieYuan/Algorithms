package sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 计数排序
 * @date 2018-10-19
 * @time 23:00
 */
public class CountSort {
    public static void main(String[] args) {
        int[] nums = {23, 1, 3, 11, 2, 2, 37, 3, 31, 5, 12, 25, 12, 15,
                22, 31, 15, 36, 1, 34};
        System.out.println(Arrays.toString(countSort(nums)));
    }

    public static int[] countSort(int[] nums) {
        int[] count = new int[38];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] result = new int[nums.length];
        for (int num : nums) {
            count[num]--;
            result[count[num]] = num;
        }
        return result;
    }
}
