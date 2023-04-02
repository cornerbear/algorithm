package subject.year2023.month4.day0402;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : corner_bear
 * @since : 2023/4/2 21:34
 * @subject : 503. 下一个更大元素 II
 * @label : 中等 : 单调栈
 * @description : 
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class NextGreaterElements {

    public static void main(String[] args) {
        NextGreaterElements t = new NextGreaterElements();
//        System.out.println(Arrays.toString(t.nextGreaterElements(new int[]{1, 2, 1})));
        System.out.println(Arrays.toString(t.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
//        System.out.println(Arrays.toString(t.nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
    }

    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < length * 2; i++) {
            int num = nums[i % length];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                Integer pop = stack.pop();
                ans[pop] = num;
            }
            if (i < length) {
                stack.push(i);
            }
        }

        return ans;
    }

    public int[] nextGreaterElements1(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);

        for (int i = 0; i < length; i++) {
            int j = i + 1;
            j = j % length;
            for (; j < length && j != i; ) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
                j++;
                j = j % length;
            }
        }

        return ans;
    }
}
