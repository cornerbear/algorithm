package subject.year2020.month11.day1128;

import java.math.BigDecimal;

/**
 * Author : zhangxiaojian
 * Date : 2020/11/28
 */
public class Solution {
    public int reversePairs(int[] nums) {
        int count = 0;
        BigDecimal jnum;
        BigDecimal inum;
        BigDecimal big = new BigDecimal(2);
        for(int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                jnum = new BigDecimal(nums[j] * 2);
                jnum = jnum.multiply(big);
                inum = new BigDecimal(nums[i]);
                if (inum.compareTo(jnum) == 1)
                    count++;
            }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.reversePairs(new int[]{1, 3, 2, 3, 1});
        System.out.println(i);
    }
}
