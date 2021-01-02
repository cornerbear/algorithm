package subject.year2020.mouth12.day1220;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/20
 * 
 * 316
 * 需要使用「栈」作为辅助的数据结构;
 * 需要记录每一个字符最后一次出现的 下标;
 * 判断当前读到的字母在栈中是否已经出现。
 */
public class Solution {
    
    public String removeDuplicateLetters(String s) {
        int length = s.length();

        char[] charArray = s.toCharArray();
        
        int[] lastIndex = new int[26];

        for (int i = 0; i < length; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>();
        
        boolean[] visited = new boolean[26];
        for (int i = 0; i < length; i++) {
            //如果已经出现
            if(visited[charArray[i] - 'a']){
                continue;
            } 
            //如果当前栈顶元素大于遍历到的元素，并且栈顶元素在之后还会出现
            while(!stack.isEmpty() && stack.peekLast() > charArray[i] && lastIndex[stack.peekLast() - 'a'] > i){
                //栈顶的可以移除，就移除栈顶的字符
                Character top = stack.removeLast();
                //并且将该字符设置为未出现
                visited[top - 'a'] = false;
            }
            
            //将当前遍历到的元素压栈
            stack.addLast(charArray[i]);
            visited[charArray[i] - 'a'] = true;
            
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        
        return sb.toString();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeDuplicateLetters("bcabc");
    }
}
