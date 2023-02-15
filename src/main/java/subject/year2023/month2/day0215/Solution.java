package subject.year2023.month2.day0215;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/14
 * Subject : 1250. 检查「好数组」
 * Label :困难 ：字符串 ： 滑动窗口
 * Describe ：
 * 给你一个正整数数组 nums，你需要从中任选一些子集，然后将子集中每一个数乘以一个 任意整数，并求出他们的和。
 * <p>
 * 假如该和结果为1，那么原数组就是一个「好数组」，则返回 True；否则请返回 False。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/check-if-it-is-a-good-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {

    public boolean isGoodArray(int[] nums) {

        int divisor = nums[0];
        for (int num : nums) {
            divisor = gcd(divisor, num);
            if (divisor == 1) {
                break;
            }
        }
        return divisor == 1;
    }

    public int gcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1;
            num1 = num2;
            num2 = temp % num2;
        }
        return num1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isGoodArray(new int[]{12, 5, 7, 23}));
    }
}
