package subject.year2020.mouth12.day1230;

import java.util.Arrays;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/30
 */
public class Solution {
    public int lastStoneWeight(int[] stones) {
        if (stones.length == 2) {
            return Math.abs(stones[0] - stones[1]);
        }
        if (stones.length == 1) {
            return stones[0];
        }
        Arrays.sort(stones);
        if (stones[stones.length - 3] == 0) {
            return stones[stones.length - 1] - stones[stones.length - 2];
        }
        stones[stones.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
        stones[stones.length - 2] = 0;
        return lastStoneWeight(stones);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.lastStoneWeight(new int[]{3, 7, 8});
        System.out.println(i);
    }
}
