package util;

import java.util.Random;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description
 * @date 2018-01-23
 * @time 21:14
 */
public class Stopwatch {
    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
        System.out.println(start);
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        System.out.println(now);
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        Random random = new Random();
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt();
        }
        double time = timer.elapsedTime();
        System.out.println(time + " seconds");
    }
}
