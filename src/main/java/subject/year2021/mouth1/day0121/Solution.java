package subject.year2021.mouth1.day0121;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/24
 * Subject : 1662. 检查两个字符串数组是否相等
 * Label ： ，：简单，：字符串，：数组
 * Describe ： 
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 *
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-two-string-arrays-are-equivalent
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    
    // 第一种解法，拼接完直接比较
    public boolean arrayStringsAreEqual1(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }

    // 第二种一个一个去比较，如果碰到不同的直接返回false
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
        while (i1 < word1.length && i2 < word2.length) {
            if (word1[i1].charAt(j1) != word2[i2].charAt(j2))
                return false;
            else { // ==
                if (j1 + 1 >= word1[i1].length()) {
                    // 此时说明word1[j1]所在的字符串已经遍历完成,i1++,遍历下一个字符串
                    j1 = 0;
                    i1++;
                }
                else // word1[j1]所在的字符串还未遍历完成,j1++,继续遍历当前字符串
                    j1++;

                if (j2 + 1 >= word2[i2].length()) {
                    j2 = 0;
                    i2++;
                }
                else
                    j2++;
            }
        }
        return i1 == word1.length && i2 == word2.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.arrayStringsAreEqual(new String[]{"a", "bb"}, new String[]{"ab", "c"});
        System.out.println(b);
    }
}
