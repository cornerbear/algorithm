package subject.year2023.month2.day0217;

/**
 * Author : flower_micro
 * Date : 2023/02/16
 * Subject : 1139. 最大的以 1 为边界的正方形
 * Label : 中等 ：数组 ： 滑动窗口
 * Describe ：
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。
 * 如果不存在，则返回 0。
 */
public class Largest1BorderedSquare {

    public int largest1BorderedSquare(int[][] grid) {
        int res = 0;

        int length = grid.length;
        for (int[] ints : grid) {
            length = Math.min(length, ints.length);
        }
        while (length > 0) {
            for (int i = 0; i < grid.length && i + length <= grid.length; i++) {
                for (int j = 0; j < grid[i].length && j + length <= grid[i].length; j++) {
                    // 初始位置
                    int pi = i;
                    int pj = j;
                    boolean flag = checkIsSquare(i, j, grid, length);
                    if (flag) {
                        return length * length;
                    }
                }
            }

            length--;
        }

        return (int)Math.pow(res, 2);
    }

    private boolean checkIsSquare(int posi, int posj, int[][] grid, int length) {
        boolean flag = true;
        for (int i = 0; i < length; i++) {
            if (posj + i <= grid[posi].length
                    && posi + length <= grid.length
                    && posj + i <= grid[posi + length - 1].length
                    && (grid[posi][posj + i] == 0 || grid[posi + length - 1][posj + i] == 0)) {
                flag = false;
                break;
            }
        }
        if (!flag) {
            return false;
        }

        for (int j = 0; j < length; j++) {
            if (posi + j <= grid.length
                    && posi + j <= grid.length
                    && posj + length <= grid[posi].length
                    && (grid[posi + j][posj] == 0 || grid[posi + j][posj + length - 1] == 0)) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Largest1BorderedSquare l = new Largest1BorderedSquare();
        System.out.println(l.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
        System.out.println(l.largest1BorderedSquare(new int[][]{{1, 1, 0, 0}}));
        System.out.println(l.largest1BorderedSquare(new int[][]{{0}}));
        // 1
        System.out.println(l.largest1BorderedSquare(new int[][]{{0, 0, 0, 1}}));
        // 1
        System.out.println(l.largest1BorderedSquare(new int[][]{{0, 1}, {1, 0}}));
    }
}
