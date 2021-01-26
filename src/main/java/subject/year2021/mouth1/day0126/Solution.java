package subject.year2021.mouth1.day0126;

import java.util.Arrays;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/26
 * Subject : 1128. 等价多米诺骨牌对的数量
 * Label : ，：简单，：数组
 * Describe :
 * 给你一个由一些多米诺骨牌组成的列表 dominoes。
 *
 * 如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
 *
 * 形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
 *
 * 在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。
 *
 * 1 <= dominoes.length <= 40000
 * 1 <= dominoes[i][j] <= 9
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public int numEquivDominoPairs(int[][] dominoes) {

        int ans = 0;
        int[] num = new int[100];
        
        for(int[] domino:dominoes){
            int val = domino[0] < domino[1] ? domino[0] * 10 + domino[1] : domino[1] * 10 + domino[0];

            // 由约束条件可知，1 <= dominoes[i][j] <= 9，
            // 为什么是 += 因为当{1,2}有两个时，此时再多一个{1,2}时，他应该与其他几个都相等，所以应该+2，再多一个时应该+3
            ans+=num[val]++;
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numEquivDominoPairs(new int[][]{{1, 2}, {2, 1}, {1, 2}, {5, 6}});
        System.out.println(i);
    }
}
