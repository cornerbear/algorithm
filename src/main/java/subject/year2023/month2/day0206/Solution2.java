package subject.year2023.month2.day0206;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/06
 * Subject : 1317. 将整数转换为两个无零整数的和
 * Label :简单 ：数组
 * Describe ：
 */

public class Solution2 {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                return new int[]{i, n - i};
            }
        }
        return null;
    }
}
