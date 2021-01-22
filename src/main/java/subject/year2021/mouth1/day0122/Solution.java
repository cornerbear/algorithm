package subject.year2021.mouth1.day0122;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/23
 * Subject : 989. 数组形式的整数加法
 * Label : ，：简单，：数组
 * Describe ： 
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 *
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-to-array-form-of-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<Integer> addToArrayForm(int[] A, int K) {

        LinkedList<Integer> ans = new LinkedList<>();
        int index = A.length - 1;
        while (index >= 0 || K > 0){
            if (index >= 0){
                K += A[index];
            }
            ans.addFirst(K%10);
            K /= 10;
            index--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.addToArrayForm(new int[]{2,1,5}, 806);
        System.out.println(list);
    }
}
