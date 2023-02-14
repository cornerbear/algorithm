package subject.year2023.month2.day0214;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/14
 * Subject : 1124. 表现良好的最长时间段
 * Label :中等 ：字符串 ： 滑动窗口
 * Describe ：
 * 给你一份工作时间表hours，上面记录着某一位员工每天的工作小时数。
 * <p>
 * 我们认为当员工一天中的工作小时数大于8 小时的时候，那么这一天就是「劳累的一天」。
 * <p>
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * <p>
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-well-performing-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution {

    public int longestWPI(int[] hours) {
        int res = 0;
        int[] cnt = new int[2];
        for (int l = 0; l < hours.length; l++) {
            cnt[0] = 0;
            cnt[1] = 0;
            int r = l;
            for (; r < hours.length; r++) {
                cnt[idx(hours[r])]++;
                if (check(cnt)) {
                    res = Math.max(r - l + 1, res);
                }
            }
            if (check(cnt)) {
                res = Math.max(r - l, res);
            }
            cnt[idx(hours[l])]--;
        }

        return res;
    }

    private int idx(int hour) {
        if (hour > 8) {
            return 0;
        } else {
            return 1;
        }
    }

    private boolean check(int[] cnt) {
        return cnt[0] > cnt[1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // 3
        System.out.println(solution.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        // 1
//        System.out.println(solution.longestWPI(new int[]{6, 6, 9}));
        // 1
//        System.out.println(solution.longestWPI(new int[]{6, 9, 6}));
    }
}
