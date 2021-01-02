package subject.year2020.mouth12.day1216;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/16
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word = s.split(" ");
        if(pattern.length() != word.length)
            return false;
        boolean [] flag = new boolean[word.length];
        
        for (int i = 0; i < word.length; i++) {
            if(!flag[i]){
                for (int j = i; j < word.length; j++) {
                    if(pattern.charAt(i) == pattern.charAt(j)){
                        flag[j] = true;
                        if(!word[i].equals(word[j])){
                            return false;
                        }
                    } else {
                        if(word[i].equals(word[j])){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
        
        
//        for (String s1 : pat) {
//            System.out.println(s1);
//        }
//        System.out.println();
//        for (String s1 : word) {
//            System.out.println(s1);
//        }
//
//        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.wordPattern("abba", "dog dog dog dog");
        System.out.println(b);
    }
}
