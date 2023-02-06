package subject.year2023.month2.day0206;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/06
 * Subject : LCP 55. 采集果实
 * Label :简单 ：数组
 * Describe ：
 */
public class Solution1 {

    public static int getMinimumTime(int[] time, int[][] fruits, int limit) {
        int result = 0;
        for (int[] fruit : fruits) {
            result += time[fruit[0]] * (fruit[1] / limit + (fruit[1] % limit == 0 ? 0 : 1));
        }
        return result;
    }

    public static void main(String[] args) {
        // time = [2,3,2], fruits = [[0,2],[1,4],[2,1]], limit = 3
//        int[] time = {2, 3, 2};
        int[] time = {1, 3, 5, 4};
//        int[][] fruits = {{0, 2}, {1, 4}, {2, 1}};
        int[][] fruits = {{2,4},{3,3},{1,4},{0,3},{3,1},{3,2},{0,4},{2,3},{1,4}};
//        int minimumTime = getMinimumTime(time, fruits, 3);
        int minimumTime = getMinimumTime(time, fruits, 2);
        System.out.println(minimumTime);
    }
}
