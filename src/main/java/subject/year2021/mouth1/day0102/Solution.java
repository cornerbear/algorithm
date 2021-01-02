package subject.year2021.mouth1.day0102;

import java.util.LinkedList;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/2
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 双向队列，数组，最大值，困难
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {

        if (nums == null || nums.length < 2) return nums;

        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();

        // 结果数组
        int[] result = new int[nums.length - k + 1];

        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            // 添加当前值对应的数组下标
            queue.addLast(i);

            // 判断当前队列中队首的值是否有效(是否在滑块范围内，如果不在，则移除)
            if (queue.peek() <= i - k) {
                queue.poll();
            }

            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }
}
