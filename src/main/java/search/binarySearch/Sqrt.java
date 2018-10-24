package search.binarySearch;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 使用二分查找解决平方根问题
 * @date 2018-10-24
 * @time 15:08
 */
public class Sqrt {
    public static void main(String[] args) {
        System.out.println(sqrt(10));
    }

    public static float sqrt(int num) {
        float low = 0, high = num, middle = num / 2;
        int times = 0;
        while (times < 20) {
            middle = (high + low) / 2;
            if (middle * middle < num) {
                // (a + num) / 2
                low = middle;
            } else if (middle * middle > num) {
                high = middle;
            } else {
                return middle;
            }
            times++;
        }
        return middle;
    }
}
