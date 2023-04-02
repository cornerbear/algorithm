package subject.year2023.month3.day0329;

import java.util.Stack;

/**
 * @author : corner_bear
 * @since : 2023/3/29 21:33
 * @subject : 84. 柱状图中最大的矩形
 * @label : 困难 : 单调栈
 * @description :
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;

        if (len == 0)
            return 0;
        if (len == 1)
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
            while (heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        LargestRectangleArea t = new LargestRectangleArea();
        t.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }
}
