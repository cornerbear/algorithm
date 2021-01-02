package subject.year2020.month10.day1025Y845;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/25
 * 845. 数组中的最长山脉
 */
public class Solution {
    public int longestMountain(int[] A) {
        int maxLength = 0;
        for (int i = 0; i < A.length; i++) {
            int left = 0;
            int right = 0;
            //循环前面
            System.out.print("l:");
            for (int j = i; j > 0; j--) {
                if(A[j-1] < A[j]) {
                    System.out.print(A[j-1]+" ");
                    left++;
                }
                else 
                    break;
            }

            //循环后面
            System.out.print("r:");
            for (int j = i; j < A.length-1; j++) {
                if(A[j+1] < A[j]) {
                    System.out.print(A[j+1]+" ");
                    right++;
                }
                else 
                    break;
            }
            if(left != 0 && right != 0){
                maxLength = (maxLength>(left+right))?maxLength:(left+right);
            }
            System.out.println(maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestMountain(new int[]{2,2,2});
        System.out.println("solution:" + i);
        Queue queue = new LinkedList();
    }
}
