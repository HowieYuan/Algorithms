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
     * 二分查找(循环)
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

    /**
     * 寻找第一个与目标数值相等的数
     */
    public static int searchFirst(int[] a, int x) {
        int h = a.length - 1;
        int l = 0;
        while (l <= h) {
            int m = (h + l) / 2;
            if (a[m] > x) {
                h = m - 1;
            } else if (a[m] < x) {
                l = m + 1;
            } else {
                if (m == 0 || a[m - 1] != x) {
                    return m;
                }
                h = m - 1;
            }
        }
        return -1;
    }

    /**
     * 寻找最后一个与目标数值相等的数
     */
    public static int searchLast(int[] a, int x) {
        int h = a.length - 1;
        int l = 0;
        while (l <= h) {
            int m = (h + l) / 2;
            if (a[m] > x) {
                h = m - 1;
            } else if (a[m] < x) {
                l = m + 1;
            } else {
                if (m == a.length - 1 || a[m + 1] != x) {
                    return m;
                }
                l = m + 1;
            }
        }
        return -1;
    }

    /**
     * 寻找第一个大于等于目标数值的数
     */
    public static int searchFirstBigger(int[] a, int x) {
        int h = a.length - 1;
        int l = 0;
        int m = 0;
        while (l <= h) {
            m = (h + l) / 2;
            if (a[m] >= x) {
                if (m == 0 || a[m - 1] < x) {
                    return m;
                }
                h = m - 1;
            } else if (a[m] < x) {
                l = m + 1;
            }
        }
        return m + 1;
    }

    /**
     * 寻找最后一个小于等于目标数值的数
     */
    public static int searchLastSmaller(int[] a, int x) {
        int h = a.length - 1;
        int l = 0;
        int m = 0;
        while (l <= h) {
            m = (h + l) / 2;
            if (a[m] > x) {
                h = m - 1;
            } else {
                if (m == a.length - 1 || a[m + 1] > x) {
                    return m;
                }
                l = m + 1;
            }
        }
        return m + 1;
    }

    /**
     * 循环有序数组进行二分查找
     */
    public static int searchInCycle(int[] a, int x) {
        int h = a.length - 1;
        int l = 0;
        while (l <= h) {
            int m = (h + l) / 2;
            if (a[l] <= a[m]) {
                if (x <= a[m] && x >= a[l]) {
                    //二分查找
                    return repeatBinarySearch2(a, l, m, x);
                }
                l = m + 1;
            } else if (x <= a[h] && x > a[m]) {
                //二分查找
                return repeatBinarySearch2(a, m + 1, h, x);
            } else {
                h = m - 1;
            }
        }
        return -1;
    }

    public static int repeatBinarySearch2(int[] a, int low, int high, int x) {
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

    public static void main(String[] args) {
//        int[] a = {0, 1, 2, 2, 2, 2, 2, 2, 3, 4, 6};
        int[] a = {6, 7, 1, 2, 3, 4, 5};
        System.out.println(searchInCycle(a, 5));
    }
}
