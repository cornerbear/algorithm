package subject.year2020.month10.day1026Y1365;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/26
 */
public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int [] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if(i != j){
                    if(nums[i] > nums[j]){
                        result[i]++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3});
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
