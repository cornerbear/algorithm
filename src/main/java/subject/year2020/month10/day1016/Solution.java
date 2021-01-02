package subject.year2020.month10.day1016;

import java.util.Arrays;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/16
 */
public class Solution {

    public int[] sortedSquares(int[] A) {
        int[] newA = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortedSquares(new int[]{-5,-1,0,3});
        
        double a = 0.0/0.0;
        double b = 1.0/0.0;
        Double c = 0.0/0.0;
        Double d = 1.0/0.0;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(a == a);
        System.out.println(b == b);
        System.out.println(c.doubleValue() == c.doubleValue());
        System.out.println(d.doubleValue() == d.doubleValue());
        
    }
}