package subject.year2020.month10.day1008;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/8
 */
public class Solution1{
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        char temp;
        while(start < end){
            temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        new Solution1().reverseString(new char[]{'h','e','l','l','o'});
    }
}