package subject.year2020.mouth12.day1226;

import java.util.Stack;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/26
 */
//84. 柱状图中最大的矩形
public class Solution {

    //暴力解法
    public int largestRectangleArea1(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        int max = heights[0];
        int temp;
        int length = heights.length;

        for (int i = 0; i < length; i++) {
            int min = heights[i];
            if (min == 0)
                continue;
            for (int j = i + 1; j < length; j++) {
                min = Math.min(min, heights[j]);
                temp = min * (j - i + 1);
                max = Math.max(max, temp);
            }
            max = Math.max(min, max);
        }


        return max;
    }

    //栈
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        if(len == 0)
            return 0;
        if(len == 1)
            return heights[0];
        
        int[] newHeights = new int[len + 2];
        for (int i = 0; i < len; i++) {
            newHeights[i + 1] = heights[i];
        }
        len += 2;
        heights = newHeights;

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        
        int max = 0;
        for (int i = 1; i < len; i++) {
            while(heights[stack.peek()] > heights[i]){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                max = Math.max(max,height * width); 
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.largestRectangleArea(new int[]{4, 2});
        System.out.println(i);
    }

}
