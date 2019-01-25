package algorithms.backtracking;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 0-1 背包问题（回溯算法）
 * @date 2019-01-25
 * @time 15:46
 */
public class Knapsack01 {
    private int maxResult = 0;
    private int[] object;
    private int maxWeight;

    public Knapsack01(int[] object, int maxWeight) {
        this.object = object;
        this.maxWeight = maxWeight;
    }

    public void solution() {
        //回溯推算
        calculate(0, 0);
    }

    public int getMaxResult() {
        return maxResult;
    }

    private void calculate(int currentIndex, int currentWeight) {
        //如果已经考察完所有的物品，或者已经装满了（剪枝）
        if (currentIndex == object.length - 1 || currentWeight == maxWeight) {
            if (currentWeight > maxResult) {
                maxResult = currentWeight;
            }
            return;
        }
        //当前物品不放入包中
        calculate(currentIndex + 1, currentWeight);
        //当前物品放入包中
        int weight = currentWeight + object[currentIndex];
        if (weight <= maxWeight) {
            calculate(currentIndex + 1, weight);
        }
    }

    public static void main(String[] args) {
        Knapsack01 knapsack01 = new Knapsack01(new int[]{1, 5, 10, 4, 8}, 13);
        knapsack01.solution();
        System.out.println(knapsack01.getMaxResult());
    }
}
