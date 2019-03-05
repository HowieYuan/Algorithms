package sort.quickSort;

import util.ArrayUtil;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 划分时从数组两边分别寻找，将最值交换
 * @date 2018-02-04
 * @time 16:32
 */
public class QuickSort {
    public int[] quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
        return a;
    }

    private void quickSort(int[] a, int low, int high) {
        // 这里必须是 >= ，因为切分出来的位置可能是 0 ，而下一步有一个 i-1
        if (low >= high) {
            return;
        }
        int i = partition2(a, low, high);
        quickSort(a, low, i - 1);
        quickSort(a, i + 1, high);
    }

    /**
     * 推荐方法1：挖坑法
     */
    private static int partition1(int[] array, int low, int high) {
        int temp = array[low];
        while (low < high) {
            while (low < high && array[high] >= temp) {
                high--;
            }
            array[low] = array[high];

            while (low < high && array[low] <= temp) {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = temp;
        return low;
    }

    /**
     * 推荐方法2：交换法
     */
    private int partition2(int[] array, int start, int end) {
        int middleValue = array[end];
        int e = end;
        end--;
        while (start < end) {
            while (array[start] < middleValue && end > start) {
                start++;
            }
            while (array[end] >= middleValue && end > start) {
                end--;
            }
            if (start < end) {
                ArrayUtil.swap(array, start, end);
            }
        }
        if (array[start] > array[e]) {
            ArrayUtil.swap(array, start, e);
        } else {
            ArrayUtil.swap(array, ++start, e);
        }
        return start;
    }

    private int partition(int[] a, int low, int high) {
        int l = low;
        //这里要先加 1，因为后面有 a[--h]，而 low 不用是因为 a[low] 不用考虑
        int h = high + 1;
        while (true) {
            // 把相等的元素也一并处理
            while (a[low] < a[--h]) {
                // 这里的 if 可以去掉，因为 a[low] 一定不会小于自身
                if (h == low) {
                    break;
                }
            }
            while (a[low] > a[++l]) {
                //这里的 if 需要保留
                if (l == high) {
                    break;
                }
            }
            // 这里是 >= 而不是 ==,因为h会一直往左走，l一直往右走，并不是两个一碰到就会break
            if (l >= h) {
                break;
            }
            ArrayUtil.swap(a, l, h);
        }
        ArrayUtil.swap(a, low, h);
        //return h 而不是 l，因为要把小的移到左边。
        return h;
    }

    /**
     * 对于小规模子数组，使用插入排序的改进
     */
    private void quickSort2(int[] a, int low, int high) {
        if (high - low + 1 < 15) {
            //如果是小规模子数组，使用插入排序
            ArrayUtil.insertSort(a, low, high);
        } else {
            int i = partition(a, low, high);
            quickSort2(a, low, i - 1);
            quickSort2(a, i + 1, high);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new QuickSort().quickSort(
                        new int[]{2,1,2,1,2,1,2,1}
                )));
    }

}
