package subject.year2021.mouth2.day0213;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.abs;

/**
 * Author : zhangxiaojian
 * Date : 2021/2/13
 * Subject : 448. 找到所有数组中消失的数字
 * Label :简单，：数组
 */
public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; ++i)
            nums[abs(nums[i])-1] = -abs(nums[abs(nums[i])-1]);
        
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        for (Integer integer : list) {
            System.out.println(integer);
        }
        
    }
}
