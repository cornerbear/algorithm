package subject.year2020.month10.day1011;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/11
 * ===================================================================================
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 注意:
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * 
 * 示例 1:
 * 输入: [1, 5, 11, 5]
 * 输出: true
 * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
 *  
 * 示例 2:
 * 输入: [1, 2, 3, 5]
 * 输出: false
 * 解释: 数组不能分割成两个元素和相等的子集.
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ===================================================================================
 * 背包问题
 * 容量为数组的一半
 * 判断每个数字的组合能填满多少
 * 例如1,5,11,5
 * 对于1 能填满 1
 * 对于1,5 能填满 1,5,6
 * 对于1,5,11 能填满 1,5,6 因为如果带上11就大于11（sum的一半）了，所以只到11
 * 对于1,5,11,5 能填满和上面一样
 * 
 * 
 */
public class Solution {
    public static boolean canPartition(int[] nums) {

        //数组的总和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //如果不能被整除就说明不能平分开
        if (sum % 2 != 0) return false;
        //数组的一半,也就是背包的容量
        int capacity = sum / 2;
        boolean[][] table = new boolean[nums.length + 1][capacity + 1];

        //临时的总和，【1】，【1,5】，【1,5,11】
        int tempSum = 0;
        for (int i = 1; i <= nums.length; i++) {
            tempSum += nums[i-1];

            for (int j = 1; j <= capacity; j++) {
                //如果临时总和大于j就不用再看了就是0
                if (tempSum >= j) {
                    //如果当前重量比背包的重量大，就不装
                    if (nums[i-1] > j) {
                        table[i][j] = table[i - 1][j];
                    } else {
                        table[i][j] = table[i-1][j] || (nums[i-1] == j) || table[i -1][j - nums[i-1]];
                    }
                }
            }
        }
        if(table[nums.length][capacity])
            return true;

        return false;
    }

    public static void main(String[] args) {
        boolean b = Solution.canPartition(new int[]{1,5,11,3});

        System.out.println(b);
    }
}