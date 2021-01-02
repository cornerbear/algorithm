package subject.year2020.mouth12.day1213;

import java.util.HashSet;
import java.util.Set;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/13
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.containsDuplicate(new int[]{1,2,3,1});
    }
}
