package subject.year2020.mouth12.day1218;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/18
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum+=s.charAt(i);
        }
        for (int i = 0; i < t.length(); i++) {
            sum-=t.charAt(i);
        }
        return (char)(-sum);
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        char theDifference = solution.findTheDifference("abcd", "abcde");
        System.out.println(theDifference);
    }
}
