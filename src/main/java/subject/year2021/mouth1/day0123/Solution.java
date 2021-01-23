package subject.year2021.mouth1.day0123;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/23
 * Subject : 1252. 奇数值单元格的数目
 * Label : ，：简单，：数组
 * Describe : 
 * 给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
 *
 * 另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci 分别表示指定的行和列（从 0 开始编号）。
 *
 * 你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
 *
 * 请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int oddCells(int n, int m, int[][] indices) {
        // 行变化次数
        int[] rowCount = new int[n];
        // 列变化次数
        int[] colCount = new int[m];
        int count = 0;
        for (int i = 0; i < indices.length; i++) {
            // 对应行的变化次数++
            rowCount[indices[i][0]]++;
            // 对应列的变化次数++
            colCount[indices[i][1]]++;
        }
        for (int i = 0; i < rowCount.length; i++) {
            for (int j = 0; j < colCount.length; j++) {
                if((rowCount[i] + colCount[j]) % 2 != 0){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}});
        System.out.println(i);
    }
}
