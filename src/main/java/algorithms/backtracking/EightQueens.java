package algorithms.backtracking;

/**
 * Created with IntelliJ IDEA
 *
 * @author yuanhaoyue swithaoy@gmail.com
 * @description 八皇后问题（回溯法）
 * @date 2019-01-24
 * @time 20:59
 */
public class EightQueens {
    private int[] matrix = new int[8];

    public void cal8queens(int rows) {
        if (rows == 8) { // 8 个棋子都放置好了，打印结果
            printEightQueens(matrix);
            return; // 8 行棋子都放好了，已经没法再往下递归了，所以就 return
        }
        for (int columns = 0; columns < 8; columns++) { // 每一行都有 8 中放法
            if (isOk(rows, columns)) { // 有些放法不满足要求
                matrix[rows] = columns; // 第 row 行的棋子放到了 column 列
                cal8queens(rows + 1); // 考察下一行
            }
        }
    }

    private boolean isOk(int rows, int columns) {
        int left = columns - 1;
        int right = columns + 1;
        for (int i = rows - 1; i >= 0; i--) {
            if (matrix[i] == columns) {
                return false;
            }
            if (left >= 0 && matrix[i] == left) {
                return false;
            }
            if (right < 8 && matrix[i] == right) {
                return false;
            }
            left--;
            right++;
        }
        return true;
    }

    private void printEightQueens(int[] matrix) {
        for (int columns : matrix) {
            for (int i = 0; i < 8; i++) {
                if (i != columns) {
                    System.out.print("- ");
                } else {
                    System.out.print("Q ");
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.cal8queens(0);
    }


}
