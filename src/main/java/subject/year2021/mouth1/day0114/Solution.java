package subject.year2021.mouth1.day0114;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/15
 * 1018. 可被 5 整除的二进制前缀
 * 
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 *
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-prefix-divisible-by-5
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * ：简单，：数组，二进制，
 */
public class Solution {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        
        int num = 0;
        for (int i = 0; i < A.length; i++) {
            num = ((num << 1) + A[i])%5;
            list.add(num == 0);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Boolean> booleans = solution.prefixesDivBy5(new int[]{0, 1, 1, 1, 1, 1});
        for (Boolean aBoolean : booleans) {
            System.out.print(aBoolean+" ");
        }
    }
}
