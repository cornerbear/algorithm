package subject.year2021.mouth1.day0109;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/19
 * Subject : 859. 亲密字符串
 * Label : ：简单，：字符串
 * Describe :
 * 给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
 *
 * 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean buddyStrings(String A, String B) {
        int alen = A.length();
        int blen = B.length();
        if(alen != blen)
            return false;
        if (A.equals(B)) {
            int[] count = new int[26];
            for (int i = 0; i < A.length(); ++i)
                count[A.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1) return true;
            return false;
        } else {
            char[] a = A.toCharArray();
            char[] b = B.toCharArray();
            int indexa = -1;
            int indexb = -1;
            int count = 0;
            for (int i = 0; i < alen; i++) {
                if(a[i] != b[i]){
                    count++;
                    if(indexa == -1){
                        indexa = i;
                    } else {
                        indexb = i;
                    }
                }
            }
            if(count == 2){
                return a[indexa] == b[indexb] && b[indexa] == a[indexb];
            }
        }
        
        return false;
    }
}
