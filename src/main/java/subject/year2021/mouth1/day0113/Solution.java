package subject.year2021.mouth1.day0113;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/13
 * 1491. 去掉最低工资和最高工资后的工资平均值
 * 给你一个整数数组 salary ，数组里每个数都是 唯一 的，其中 salary[i] 是第 i 个员工的工资。
 *
 * 请你返回去掉最低工资和最高工资以后，剩下员工工资的平均值。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-salary-excluding-the-minimum-and-maximum-salary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ：简单 ：数组 ：最大值
 */
public class Solution {

    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        double sum = 0;
        for (int i : salary) {
            if(i > max) max = i;
            if(i < min) min = i;
            sum += i;
        }
        return (sum - max - min)/(salary.length - 2);
    }
}
