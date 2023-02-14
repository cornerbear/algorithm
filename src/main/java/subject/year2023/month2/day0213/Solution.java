package subject.year2023.month2.day0213;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/13
 * Subject : 1234. 替换子串得到平衡字符串
 * Label :中等 ：字符串 ： 滑动窗口
 * Describe ：
 * 有一个只含有'Q', 'W', 'E','R'四种字符，且长度为 n的字符串。
 * <p>
 * 假如在该字符串中，这四个字符都恰好出现n/4次，那么它就是一个「平衡字符串」。
 * <p>
 * <p>
 * <p>
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * <p>
 * 你可以用和「待替换子串」长度相同的任何 其他字符串来完成替换。
 * <p>
 * 请返回待替换子串的最小可能长度。
 * <p>
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/replace-the-substring-for-balanced-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int balancedString(String s) {

        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[idx(s.charAt(i))]++;
        }
        int res = s.length();
        int partial = s.length() / 4;

        if (check(cnt, partial))
            return 0;
        for (int l = 0, r = 0; l < s.length(); l++) {
            while (r < s.length() && !check(cnt, partial)) {
                cnt[idx(s.charAt(r))]--;
                r++;
            }
            if (!check(cnt, partial)) {
                break;
            }
            res = Math.min(res, r - l);
            cnt[idx(s.charAt(l))]++;
        }
        return res;
    }

    public int idx(char c) {
        return c - 'A';
    }

    public boolean check(int[] cnt, int partial) {
        if (cnt[idx('Q')] > partial || cnt[idx('W')] > partial || cnt[idx('E')] > partial || cnt[idx('R')] > partial) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.balancedString("QQQQ"));
        System.out.println(solution.balancedString("WWEQERQWQWWRWWERQWEQ"));
    }
}
