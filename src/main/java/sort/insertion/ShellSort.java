package sort.insertion;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 希尔排序
 * @date 2018-02-05
 * @time 22:02
 */
public class ShellSort {
    int[] shellSort(int[] a) {
        int length = a.length;
        int temp, j;
        //递增序列 1，4，13，40，121..... , 初始 h < 数组长度
        int h = 1;
        while (h < length / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            //不需要进行交换的插入排序
            for (int i = h; i < length; i++) {
                temp = a[i];
                for (j = i; j - h >= 0 && temp < a[j - h]; j -= h) {
                    a[j] = a[j - h];
                }
                a[j] = temp;
            }
            h /= 3;
        }
        return a;
    }
}
