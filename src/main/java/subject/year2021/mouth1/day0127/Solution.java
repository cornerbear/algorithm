package subject.year2021.mouth1.day0127;

import static java.lang.Math.*;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/26
 * Subject : 1737. 满足三条件之一需改变的最少字符数
 * Label :中等 ：字符串 ：贪心
 * Describe：
 * 给你两个字符串 a 和 b ，二者均由小写字母组成。一步操作中，你可以将 a 或 b 中的 任一字符 改变为 任一小写字母 。
 *
 * 操作的最终目标是满足下列三个条件 之一 ：
 *
 * a 中的 每个字母 在字母表中 严格小于 b 中的 每个字母 。
 * b 中的 每个字母 在字母表中 严格小于 a 中的 每个字母 。
 * a 和 b 都 由 同一个 字母组成。
 * 返回达成目标所需的 最少 操作数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int minCharacters(String a, String b) {
        
        int[] va = new int[26];
        int[] vb = new int[26];
        for (int i = 0; i < a.length(); i++) {
            va[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            vb[b.charAt(i) - 'a']++;
        }

        // t 等于某个字母的最多的出现次数
        int t = 0;
        for (int i = 0; i < 26; ++i) {
            t = max(t, va[i] + vb[i]);
        }
        int sa = a.length(), sb = b.length();
        
        int res = sa + sb - t;

        for (int i = 25, ta = 0, tb = 0; i > 0; i--) {
//            ta : va中i及i之后所有个数和, (sa - ta) : va中i之前所有个数和
//            tb : vb中i及i之后所有个数和, (sb - tb) : vb中i之前所有个数和
//            ta + (sb - tb) : va中i及i之后的元素都改成小于i, vb中i之前的元素改成大于i
//            tb + (sa - ta) : vb中i及i之后的元素都改成小于i, va中i之前的元素改成大于i
//            参考大佬：https://leetcode-cn.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/comments/757897
            ta += va[i];
            tb += vb[i];
            res = min( res, min( ta + (sb - tb), tb + (sa - ta) ) );
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minCharacters("dabadd", "cda");
        System.out.println(i);
    }
}
