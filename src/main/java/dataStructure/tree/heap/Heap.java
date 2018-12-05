package dataStructure.tree.heap;

import java.util.Arrays;

import static util.ArrayUtil.swap;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 堆
 * @date 2018-11-26
 * @time 22:08
 */
public class Heap {
    private int[] a; // 数组，从下标 1 开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int[] a, int count) {
        this.a = a;
        n = a.length - 2;
        this.count = count;
    }

    public Heap(int capicity) {
        a = new int[capicity + 1];
        n = capicity;
        count = 0;
    }


    /**
     * 堆插入
     */
    public void insert(int data) {
        //堆已满
        if (count >= n) {
            return;
        }
        int current = count + 1;
        a[current] = data;
        while (a[current / 2] < a[current] && current / 2 > 0) {
            swap(a, current / 2, current);
            current /= 2;
        }
    }

    /**
     * 删除大顶堆顶元素
     */
    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count--];
        int current = 1;
        while (current * 2 < count) {
            int max = current * 2;
            if (a[max] < a[max + 1]) {
                max++;
            }
            if (a[max] > a[current]) {
                swap(a, current, max);
            }
            current = max;
        }
    }

    /**
     * 建堆（大顶）
     */
    public static void buildHeap1(int[] a) {
        for (int i = 1; i < a.length; i++) {

        }
    }

    /**
     * 建堆（大顶）
     */
    public static void buildHeap2(int[] a) {

    }


    public static void main(String[] args) {
        int[] a = {0, 10, 9, 8, 5, 4, 7, 6, 2, 1, 3};
        Heap heap = new Heap(a, 10);
        heap.removeMax();
        System.out.println(Arrays.toString(heap.a));
    }

}

