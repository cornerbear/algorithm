package subject.year2023.month2.day0206;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/06
 * Subject : 2210. 统计数组中峰和谷的数量
 * Label :简单 ：数组
 * Describe ：
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums 。如果两侧距 i 最近的不相等邻居的值均小于 nums[i] ，则下标 i 是 nums 中，某个峰的一部分。类似地，如果两侧距 i 最近的不相等邻居的值均大于 nums[i] ，则下标 i 是 nums 中某个谷的一部分。对于相邻下标 i 和 j ，如果 nums[i] == nums[j] ， 则认为这两下标属于 同一个 峰或谷。
 * <p>
 * 注意，要使某个下标所做峰或谷的一部分，那么它左右两侧必须 都 存在不相等邻居。
 * <p>
 * 返回 nums 中峰和谷的数量。
 */
public class Solution4 {

    public static int countHillValley(int[] nums) {

        int mid;
        int left;
        int right;
        int count = 0;
        for (int i = 1, j; i < nums.length - 1; i = j) {
            j = i + 1;
            left = nums[i - 1];
            mid = nums[i];
            right = nums[j];
            while (right == mid && j + 1 <= nums.length - 1) {
                right = nums[++j];
            }
            if ((mid < left && mid < right) || (mid > left && mid > right)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 1, 6, 5};
        int i = countHillValley(nums);
        System.out.println(i);
    }
}
