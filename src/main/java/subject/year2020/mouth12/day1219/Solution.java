package subject.year2020.mouth12.day1219;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/19
 */
public class Solution {
    
    public void rotate(int[][] matrix) {
        
        int m = matrix.length;
        
        int temp;
        
        for (int i = 0; i < m; i++) {	//转置
            for (int j = 0; j < i; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < m; i++) {	//水平翻转
            for (int j = 0; j < m / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - 1 - j];
                matrix[i][m - 1 - j] = temp;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[][]{{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}});
    }
}
