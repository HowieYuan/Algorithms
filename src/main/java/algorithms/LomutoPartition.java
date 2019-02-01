package algorithms;

import util.ArrayUtil;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description Lomuto 划分策略
 *              可用于快排的划分算法，代码十分简洁
 * @date 2018-04-19
 * @time 22:32
 */
public class LomutoPartition {
    public int[] lomutoPartition(int[] a) {
        int p = a[0];
        int num = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < p) {
                num++;
                //发现小于 a[0] 的值，此时必满足以下两者其一： a[num] 大于 a[0] 或 num 等于 i
                //因此交换 a[i] a[num]
                ArrayUtil.swap(a, i, num);
            }
        }
        //最后交换 a[0] 与 a[num] , a[num] 为最后一个小于 a[0] 的值
        ArrayUtil.swap(a, 0, num);
        return a;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 4, 2, 6, 1, 1};
        a = new LomutoPartition().lomutoPartition(a);
        System.out.println(Arrays.toString(a));
    }
}
