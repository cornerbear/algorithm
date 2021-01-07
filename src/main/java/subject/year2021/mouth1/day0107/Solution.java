package subject.year2021.mouth1.day0107;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/15
 * Subject : 122. 买卖股票的最佳时机 II
 * Label : ：简单，：数组，：贪心，：动态规划
 * Describe : 
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    
    //  贪心
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int maxProfit = 0;
        for (int i = 1; i < len; i++) {
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：持有现金
        // 1：持有股票
        //dp[i][0] 表示第 i 天交易完后手里没有股票的最大利润，
        //dp[i][1] 表示第 i 天交易完后手里持有一支股票的最大利润
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];  //第一天买股票，所以金额用来买股票，所以是“-prices[0]”

        for (int i = 1; i < len; i++) {
            // 这两行调换顺序也是可以的
            // 如果当天没有持有股票，说明：
            //     1. 要么昨天没股票，则今天啥也没干，依旧持有现金，现金就没变还是dp[i - 1][0]
            //     2. 要么昨天有股票，然后今天买了，所以就是买股票的钱（负的）加上今天卖股票赚的钱
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            // 如果当天持有股票，说明：
            //     1. 要么昨天有股票，然后今天啥也没干，依旧持有股票，
            //     2. 要么昨天没股票，然后今天买了，剩下的现金，然后减去买股票的钱
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        //最终持有现金肯定是比持有股票，的现金多的，所以直接返回0
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(i);
    }

}
