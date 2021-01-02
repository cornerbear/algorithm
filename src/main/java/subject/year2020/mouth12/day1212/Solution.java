package subject.year2020.mouth12.day1212;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/12
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
//        int [] result = new int[nums.length-1];
//        for (int i = 0; i < nums.length-1; i++) {
//            if(nums[i+1] - nums[i] > 0) result[i] = 1;
//            else if(nums[i+1] - nums[i] < 0) result[i] = -1;
//            else result[i] = 0;
//        }
//
//        for (int i : result) {
//            System.out.print(i+" ");
//        }
//        int maxLength = -1;
//        int length = 0;
//        for (int i = 0; i < result.length-1; i++) {
//            if(result[i] != 0 && result[i] == -result[i+1])
//                length++;
//                
//        }
//        
//        System.out.println();
//        return length==0?1:length+2;
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.wiggleMaxLength(new int[]{1,2,1,0,-1,1});
        System.out.println(i);
    }
}
