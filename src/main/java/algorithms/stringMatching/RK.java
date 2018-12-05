package algorithms.stringMatching;


import static java.lang.Math.pow;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description Rabin-Karp 算法  BF算法+哈希算法
 * @date 2018-12-05
 * @time 19:33
 */
public class RK {
    public static int rabinKarp(char[] h, char[] s) {
        int length = s.length, shash = hash(s, 0, length);
        for (int i = 0; i <= h.length - s.length; i++) {
            int hash = hash(h, i, i + length);
            if (hash == shash) {
                return i;
            }
        }
        return -1;
    }

    private static int hash(char[] chars, int start, int end) {
        int num = end - start - 1, hash = 0;
        for (int i = start; i < end; i++) {
            hash += (chars[i] - 97) * pow(26, num--);
        }
        return hash;
    }

    public static void main(String[] args) {
        char[] h = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] s = {'d', 'e', 'e'};
        System.out.println(rabinKarp(h, s));
    }
}
