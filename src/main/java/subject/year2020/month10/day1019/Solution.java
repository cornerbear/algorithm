package subject.year2020.month10.day1019;


/**
 * Author : zhangxiaojian
 * Date : 2020/10/19
 */
public class Solution {

    public boolean backspaceCompare(String S, String T) {
        return getString(S).equals(getString(T));
    }
    public String getString(String str){
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);
            if(c == '#'){
                sb.deleteCharAt(sb.length()-1);
                if(sb.length() != 0)
                    sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.backspaceCompare("ab##", "c#d#");
        System.out.println(b);
    }
}
