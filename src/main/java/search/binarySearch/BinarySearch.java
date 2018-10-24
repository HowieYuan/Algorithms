package search.binarySearch;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 二分查找（折半查找）
 * @date 2018-07-11
 * @time 20:25
 */
public class BinarySearch {
    /**
     * 循环二分查找
     *
     * @param a 数组
     * @param x 待查元素
     * @return 元素位置
     */
    public static int repeatBinarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            // (low + high) / 2;
            int middle = low + (high - low) / 2;
            if (x == a[middle]) {
                return middle;
            } else if (x < a[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 递归二分查找
     *
     * @param a 数组
     * @param x 待查元素
     * @return 元素位置
     */
    public static int recursionBinarySearch(int[] a, int x) {
        return recursionBinarySearch(a, x, 0, a.length - 1);
    }

    private static int recursionBinarySearch(int[] a, int x, int begin, int end) {
        int middle = (end + begin) / 2;
        if (begin > end || begin > a.length - 1) {
            return -1;
        }
        if (x == a[middle]) {
            return middle;
        }
        if (x > a[middle]) {
            return recursionBinarySearch(a, x, middle + 1, end);
        }
        return recursionBinarySearch(a, x, begin, middle - 1);
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5};
        System.out.println(recursionBinarySearch(a, -1));
    }
}
