package algorithms;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description DP 动态规划
 * @date 2018-04-03
 * @time 12:36
 */
public class DP {
    /**
     * 例子 1：
     * 给定一个序列（至少含有 1 个数），从该序列中寻找一个连续的子序列，使得子序列的和最大。
     * 例如，给定序列 [-2,1,-3,4,-1,2,1,-5,4]，
     * 连续子序列 [4,-1,2,1] 的和最大，为 6。
     *
     * 每一步规划即为一个子问题，将子问题结果存放于 temp 数组
     */
    public int maxSubArray(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp[i] = nums[i] + (temp[i - 1] > 0 ? temp[i - 1] : 0);
            max = max > temp[i] ? max : temp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new DP().maxSubArray(nums));
    }
}
