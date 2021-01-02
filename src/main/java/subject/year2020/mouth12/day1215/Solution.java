package subject.year2020.mouth12.day1215;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/15
 */
public class Solution {
    public int monotoneIncreasingDigits(int N) {

        String s = String.valueOf(N);
        int length = s.length();
        char[] chars = s.toCharArray();
        int flag = length;
        for (int i = length - 1; i >= 1; i--) {
            if (chars[i] < chars[i - 1]) {
                flag = i;
                chars[i - 1]--;
            }
        }

        for (int i = flag; i < length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.monotoneIncreasingDigits(33212);
        System.out.println(i);
    }

}
