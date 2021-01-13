package subject.year2021.mouth1.day0111;

import java.util.*;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/11
 */

//今天的leetcode不会，选择自出题，嘿嘿
    //今天的题目是：排列组合！
public class Solution {
    
    public List<Map<String,String>> combination(){
        String[] color = new String[]{"红色","蓝色","绿色","紫色","彩虹色","钻石色"};
        String[] size = new String[]{"大","小"};
        String[] version = new String[]{"1.0","2.0"};
        List<String[]> lists = new ArrayList<>();
        lists.add(color);
        lists.add(size);
        lists.add(version);
        Stack<String> stack = new Stack<>();
        recursion(stack,lists,lists.size(),0);
        return null;
    }
    
    public void recursion(Stack<String> stack,List<String[]> lists,int depth,int nowDepth){
        if(nowDepth == depth) {
            System.out.println(stack);
            return;
        }
        for(int i = 0; i < lists.get(nowDepth).length; i++) {
            stack.add(lists.get(nowDepth)[i]);
            recursion(stack,lists,lists.size(),nowDepth + 1);
            stack.pop();
        }
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Map<String, String>> combination = solution.combination();
        for (Map<String, String> stringStringMap : combination) {
            System.out.println(stringStringMap);
        }
    }

}
