package algorithms.DynamicProgramming;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 动态规划处理0-1背包问题
 * @date 2019-01-28
 * @time 17:38
 */
public class Knapsack01 {
    /**
     * 二维数组解法
     *
     * @param weight 物品重量数组
     * @param w      背包最大承重
     * @return 结果：最大重量
     */
    public int solution1(int[] weight, int w) {
        int size = weight.length;
        if (size <= 0) {
            return 0;
        }
        boolean[][] states = new boolean[size][w + 1];
        states[0][0] = true;
        states[0][weight[0]] = true;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] == true) {
                    states[i][j] = true;
                }
            }
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j] == true) {
                    states[i][j + weight[i]] = true;
                }
            }
        }
        while (w > 0) {
            if (states[size - 1][w] == true) {
                return w;
            }
            w--;
        }
        return 0;
    }

    /**
     * 一维数组解法
     *
     * @param weight 物品重量数组
     * @param w      背包最大承重
     * @return 结果：最大重量
     */
    public int solution2(int[] weight, int w) {
        if (weight.length <= 0) {
            return 0;
        }
        boolean[] states = new boolean[w + 1];
        states[0] = true;
        states[weight[0]] = true;
        for (int i = 1; i < weight.length; i++) {
            //这边必须从最后往前遍历，不然会出现重复计算的问题
            for (int j = w - weight[i]; j >= 0; j--) {
                if (states[j] == true) {
                    states[j + weight[i]] = true;
                }
            }
        }
        while (w > 0) {
            if (states[w] == true) {
                return w;
            }
            w--;
        }
        return 0;
    }

    /**
     * 问题升级：引入物品的价值，求在满足背包最大重量限制的前提下，背包中可装入物品的最大总价值
     *
     * @param weight 物品重量数组
     * @param w      背包最大承重
     * @return 结果：最大重量
     */
    public int solution0(int[] weight, int[] value, int w) {
        int size = weight.length;
        if (size <= 0) {
            return 0;
        }
        int[][] states = new int[size][w + 1];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= w; j++) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        states[0][weight[0]] = value[0];
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= w; j++) {
                if (states[i - 1][j] >= 0) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <= w - weight[i]; j++) {
                if (states[i - 1][j] >= 0) {
                    int newValue = states[i - 1][j] + value[i];
                    if (newValue > states[i][j + weight[i]]) {
                        states[i][j + weight[i]] = newValue;
                    }
                }
            }
        }
        int maxValue = 0;
        while (w > 0) {
            if (states[size - 1][w] > maxValue)  {
                maxValue = states[size - 1][w];
            }
            w--;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(new Knapsack01().solution1(new int[]{2, 2, 6, 3, 4}, 9));
    }
}
