package subject.year2023.month3.day0326;

/**
 * @author : corner_bear
 * @since : 2023/3/26 21:08
 * @subject : 240. 搜索二维矩阵 II
 * @label : 中等 :
 * @description :
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 从矩阵右上角开始找，这样子，向左递减，向下递增，所以比大小的时候就可以确定出唯一的路径了；
 * 如果从左上角走，比他大则两边都可以走，最终走不通
 */

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else if (matrix[m][n] < target) {
                m++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix t = new SearchMatrix();
//        System.out.println(t.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5));
        System.out.println(t.searchMatrix(new int[][]{{-5}}, -5));
    }

}
