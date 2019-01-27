package algorithms;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 摩尔投票算法
 * @date 2018-03-13
 * @time 16:51
 */
public class MooreVoting {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 2, 1, 2};
        System.out.println(new MooreVoting().majorityElement(nums));
    }

    /**
     * 找出一组数字序列中出现次数大于总数1/2的数字（并且假设这个数字一定存在）。
     * 显然这个数字只可能有一个。
     *
     * 摩尔投票算法是基于这个事实：每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），
     * 最后剩下一个数字或几个相同的数字，不一定是出现次数大于总数一半的那个。
     * 但是抵消掉的，肯定不是结果
     */
    private int majorityElement(int[] nums) {
        int count = 0, res = 0;
        for(int a : nums) {
            if(count == 0) {
                res = a;
                count++;
            } else if (res != a) {
                count--;
            } else {
                count++;
            }
        }
        int verification = 0;
        for (int a : nums) {
            if (a == res) {
                verification++;
            }
        }
        if (verification > nums.length / 2) {
            return res;
        } else {
            return -1;
        }

    }
}
