package subject.year2021.mouth1.day0112;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/12
 * 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * 
 * ：中等，：数组，：二维数组，：矩阵
 */
public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0; int down = m - 1; int left = 0; int right = n - 1;
        
        while(true){
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            if(++up > down) break;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            if(--right < left) break;
            for (int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            if(--down < up) break;
            for (int i = down; i >= up; i++) {
                list.add(matrix[i][left]);
            }
            if(++left > right) break;
            
        }
        return list;
    }
}
