package subject.year2021.mouth1.day0128;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/28
 * Subject : 724. 寻找数组的中心索引
 * Label ：简单 ：数组
 * Describe ： 
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
 *
 * 注意：中心索引可能出现在数组的两端。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;
        int left = 0;
        int right = 0;
        for (int i = 1; i < nums.length; i++) {
            right += nums[i];
        }
        if(left == right){
            return 0;
        }
        for (int i = 1; i < nums.length; i++) {
            left += nums[i-1];
            if(i != nums.length - 1){
                right -= nums[i];
            } else {
                right = 0;
            }
            if(left == right)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
        System.out.println(i);
    }
}
