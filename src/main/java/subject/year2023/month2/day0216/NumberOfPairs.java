package subject.year2023.month2.day0216;

/**
 * Author : flower_micro
 * Date : 2023/02/16
 * Subject : 2341. 数组能形成多少数对
 * Label : 简单 ：字符串 ： 滑动窗口
 * Describe ：
 * 给你一个下标从 0 开始的整数数组 nums 。在一步操作中，你可以执行以下步骤：
 * <p>
 * 从 nums 选出 两个 相等的 整数
 * 从 nums 中移除这两个整数，形成一个 数对
 * 请你在 nums 上多次执行此操作直到无法继续执行。
 * <p>
 * 返回一个下标从 0 开始、长度为 2 的整数数组 answer 作为答案，其中 answer[0] 是形成的数对数目，answer[1] 是对 nums 尽可能执行上述操作后剩下的整数数目。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-number-of-pairs-in-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfPairs {

    public int[] numberOfPairs(int[] nums) {
        int[] answer = new int[2];
        int[] tmp = new int[101];

        for (int num : nums) {
            tmp[num]++;
        }
        for (int num : tmp) {
            answer[0] += num / 2;
            answer[1] += num % 2;
        }

        return answer;
    }

    public static void main(String[] args) {
        NumberOfPairs n = new NumberOfPairs();
        int[] ints = n.numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2});
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
