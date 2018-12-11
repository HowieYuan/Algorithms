package algorithms.stringMatching;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description Boyer-Moore算法
 * @date 2018-12-11
 * @time 20:03
 */
public class BM {
    private static final int SIZE = 256;

    /**
     * bm 算法
     *
     * @param a 主串
     * @param n 主串长度
     * @param b 模式串
     * @param m 模式串的长度
     */
    public int bm(char[] a, int n, char[] b, int m) {
        // 坏字符哈希表（记录模式串中每个字符最后出现的位置）
        int[] bc = new int[SIZE];
        // 构建坏字符哈希表
        generateBC(b, m, bc);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b, m, suffix, prefix);
        int i = 0;
        while (i <= n - m) {
            // j 表示主串与模式串匹配的第一个字符
            int j;
            // 模式串从后往前匹配
            for (j = m - 1; j >= 0; --j) {
                // 坏字符对应模式串中的下标是 j
                if (a[i + j] != b[j]) {
                    break;
                }
            }
            // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            if (j < 0) {
                return i;
            }
            //坏字符规则计算出的下一个位置
            int x = j - bc[(int) a[i + j]];
            int y = 0;
            // 如果有好后缀的话
            if (j < m - 1) {
                //好后缀规则计算出的下一个位置
                y = moveByGS(j, m, suffix, prefix);
            }
            //比较两个规则，选择大者
            i = i + Math.max(x, y);
        }
        return -1;
    }

    /**
     * 构建坏字符哈希表
     *
     * @param b  模式串数组
     * @param m  模式串数组大小
     * @param bc 记录模式串中每个字符最后出现的位置的数组
     */
    private void generateBC(char[] b, int m, int[] bc) {
        for (int i = 0; i < SIZE; ++i) {
            bc[i] = -1; // 初始化 bc
        }
        for (int i = 0; i < m; ++i) {
            int ascii = (int) b[i]; // 计算 b[i] 的 ASCII 值
            bc[ascii] = i;
        }
    }


    /**
     * 构建好后缀算法数组
     *
     * @param b      模式串数组
     * @param m      模式串数组大小
     * @param suffix 记录每个好后缀的最后出现位置
     * @param prefix 记录模式串的后缀子串是否能匹配模式串的前缀子串。
     */
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; ++i) { // 初始化
            suffix[i] = -1;
            prefix[i] = false;
        }
        for (int i = 0; i < m - 1; ++i) { // b[0, i]
            int j = i;
            int k = 0; // 公共后缀子串长度
            while (j >= 0 && b[j] == b[m - 1 - k]) { // 与 b[0, m-1] 求公共后缀子串
                --j;
                ++k;
                suffix[k] = j + 1; //j+1 表示公共后缀子串在 b[0, i] 中的起始下标
            }
            if (j == -1) {
                prefix[k] = true; // 如果公共后缀子串也是模式串的前缀子串
            }
        }
    }

    /**
     * 计算好后缀规则的下一个移动距离
     *
     * @param j      模式串中第一个不相同的字符的下标
     * @param m      模式串长度
     * @param suffix 记录每个好后缀的最后出现位置
     * @param prefix 记录模式串的后缀子串是否能匹配模式串的前缀子串。
     */
    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        // 好后缀长度
        int k = m - 1 - j;
        if (suffix[k] != -1) {
            return j - suffix[k] + 1;
        }
        // 好后缀并没有再次出现，所以检查 prefix，判断是否有后缀子串匹配前缀子串的情况
        for (int r = j + 2; r <= m - 1; ++r) {
            if (prefix[m - r]) {
                return r;
            }
        }
        return m;
    }


    public static void main(String[] args) {
        char[] b = {'c', 'a', 'b', 'c', 'a', 'b'};
        int[] suffix = new int[6];
        boolean[] prefix = new boolean[6];
        new BM().generateGS(b, 6, suffix, prefix);
        System.out.println(Arrays.toString(suffix));
        System.out.println(Arrays.toString(prefix));
    }
}
