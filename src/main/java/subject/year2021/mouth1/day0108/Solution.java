package subject.year2021.mouth1.day0108;

import java.util.Arrays;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/8
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * :中等（） ,:数组
 */
public class Solution {

    
    //
    public void rotate_1(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        int temp;
        for (int i = 0; i < k; i++) {
            temp = nums[len-1];
            for (int j = len - 1; j > 0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }

        for (int num : nums) {
            System.out.print(num+" ");
        }
    }

    //翻转
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int temp ;
        while (start < end) {
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.rotate(new int[]{1,2,3,4,5,6,7},3);
    }
}
