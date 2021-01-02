package subject.year2020.mouth12.day1221;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/21
 */
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];

        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min((dp[i - 1] + cost[i - 1]), (dp[i - 2] + cost[i - 2]));
        }

        for (int i = 0; i <= len; i++) {
            System.out.print(dp[i] + " ");
            System.out.println();
        }


        return dp[len];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    }


}
