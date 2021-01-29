package subject.year2021.mouth1.day0129;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/27
 * Subject : 1437. 是否所有 1 都至少相隔 k 个元素
 * Label :简单 ：数组
 * Describe ： 
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 */
public class Solution {

    public boolean kLengthApart(int[] nums, int k) {

        int pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                if(pos == -1) 
                    pos = i;
                else {
                    if(i - pos - 1 < k) 
                        return false;
                    else 
                        pos = i;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.kLengthApart(new int[]{1,0,0,1,0,1}, 2);
        System.out.println(b);
    }
}
