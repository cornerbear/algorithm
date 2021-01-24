package subject.year2021.mouth1.day0124;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/24
 * Subject ： 674. 最长连续递增序列
 * Label ： ，：简单，：数组
 * Describe ： 
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 *
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int findLengthOfLCIS(int[] nums) {
        
        if(nums.length<1){
            return 0;
        }
        
        // 表示一个序列的起始位置
        int start = 0;
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                // 最大的序列长度为 当前下标减去当前序列的起始位置
                max = Math.max(i - start + 1,max);
            }else{
                // 如果此时遇到小的值，则开启一个新序列
                start = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int lengthOfLCIS = solution.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7});
        System.out.println(lengthOfLCIS);
    }
}
