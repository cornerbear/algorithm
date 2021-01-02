package subject.year2020.month11.day1126;

/**
 * Author : zhangxiaojian
 * Date : 2020/11/25
 */
public class Solution {
    public String sortString(String s) {
        char[] chars = s.toCharArray();
        int[] charArray = new int[26];
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < chars.length; i++) {
            charArray[chars[i]-97]++;
        }
        boolean flag = true;
        while(flag){
            flag = false;
            for (int i = 0; i < charArray.length; i++) {
                if(charArray[i] != 0){
                    flag = true;
                    sb.append((char)(i+97));
                    charArray[i]--;
                }
            }

            for (int i = charArray.length-1; i >= 0; i--) {
                if(charArray[i] != 0){
                    flag = true;
                    sb.append((char)(i+97));
                    charArray[i]--;
                }
            }
        }
        
        
        System.out.println(sb.toString());
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortString("aaaabbbbcccc");
        
    }
}
