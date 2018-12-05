package algorithms.stringMatching;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description Brute Force 暴力字符串匹配算法
 * @date 2018-12-05
 * @time 18:38
 */
public class BF {
    public static int bruteForce(char[] h, char[] s) {
        if (h.length < s.length) {
            return -1;
        }
        for (int i = 0; i <= h.length - s.length; i++) {
            int j = i;
            for (char c : s) {
                if (c != h[j]) {
                    break;
                }
                j++;
            }
            if (j == i + s.length) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        char[] h = {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] s = {'e', 'f','d'};
        System.out.println(bruteForce(h, s));
    }
}
