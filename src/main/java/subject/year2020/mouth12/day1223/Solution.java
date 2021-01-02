package subject.year2020.mouth12.day1223;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/23
 */
public class Solution {

    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        if("".equals(s)){
            return -1;
        }
        int[] num = new int[26];
        for (char aChar : chars) {
            num[aChar-'a']++;
        }
        for (int i = 0; i < num.length; i++) {
            if(num[chars[i]-'a'] == 1)
                return i;
        }
        return -1;
    }
}
