package subject.year2020.month11.day1119;

/**
 * Author : zhangxiaojian
 * Date : 2020/11/19
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0){
                count++;
            } else {
                nums[flag] = nums[i];
                flag++;
            }
        }
        for (int i = flag; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.moveZeroes(new int[]{0,1,0,3,12});
    }
}
