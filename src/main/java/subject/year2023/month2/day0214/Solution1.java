package subject.year2023.month2.day0214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/14
 * Subject : 15. 三数之和
 * Label :中等 ：数组 ：
 * Describe ：
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * <p>
 * 你返回所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution1 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) return lists;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int curr = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {

                int tmp = curr + nums[l] + nums[r];
                if (tmp == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    while (l < r && nums[l + 1] == nums[l]) l++;
                    while (l < r && nums[r - 1] == nums[r]) r--;
                    l++;
                    r--;

                } else if (tmp < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
