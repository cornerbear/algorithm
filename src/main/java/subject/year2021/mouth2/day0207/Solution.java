package subject.year2021.mouth2.day0207;

/**
 * Author : zhangxiaojian
 * Date : 2021/2/7
 * Subject： 665. 非递减数列
 * Label :简单 ：数组
 * Describe : 
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class Solution {

    public boolean checkPossibility(int[] nums) {
        
        int n = nums.length, count = 0;
        
        for (int i = 0; i < n - 1; ++i) {
            
            if (nums[i] > nums[i + 1]) {
                
                count++;
                
                if (count > 1) {
                    return false;
                }
                
                // 如果不是第一个并且后一个数字比前一个数字也小 
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    
                    nums[i + 1] = nums[i];
                    
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.checkPossibility(new int[]{5,7,1,8});
        System.out.println(b);
    }
}
