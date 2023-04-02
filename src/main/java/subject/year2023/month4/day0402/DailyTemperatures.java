package subject.year2023.month4.day0402;

import java.text.ParseException;
import java.util.*;

/**
 * @author : corner_bear
 * @since : 2023/4/2 14:21
 * @subject : 739. 每日温度
 * @label : 中等
 * @description :
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) throws ParseException {

        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) throws ParseException {
        DailyTemperatures t = new DailyTemperatures();
        System.out.println(Arrays.toString(t.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
//        System.out.println(Arrays.toString(t.dailyTemperatures(new int[]{30, 40, 50, 60})));
//        System.out.println(Arrays.toString(t.dailyTemperatures(new int[]{80, 34, 80, 80, 80, 34, 34, 34, 34, 34})));
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        int i = length - 1;
        result[i] = 0;
        for (int j = length - 1; j >= 1; ) {
            if (temperatures[j - 1] < temperatures[j])
                break;
            else j--;
            i = j;
            result[i] = 0;
        }
        Stack<Integer> deque = new Stack<>();
        for (; i >= 0; i--) {
            int cur = temperatures[i];
            if (deque.isEmpty()) {
                deque.push(i);
                result[i] = 0;
            } else if (cur >= temperatures[deque.peek()]) {
                while (!deque.isEmpty() && cur >= temperatures[deque.peek()]) {
                    deque.pop();
                }
                if (deque.isEmpty()) {
                    result[i] = 0;
                    deque.push(i);
                    continue;
                }
                result[i] = deque.peek() - i;
                deque.push(i);
            } else if (cur < temperatures[deque.peek()]) {
                deque.push(i);
                result[i] = deque.peek() - i + 1;
            }
        }

        return result;
    }

    public int[] dailyTemperatures1(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            int day = 0;
            for (int j = i + 1; j < length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    day = j - i;
                    break;
                }
            }
            result[i] = day;
        }
        return result;
    }
}
