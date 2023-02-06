package subject.year2023.month2.day0206;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/06
 * Subject : 1094. 拼车
 * Label :中等 ：数组 ： 差分
 * Describe ：
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/car-pooling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Solution3 {
    public static boolean carPooling(int[][] trips, int capacity) {
        int[] journey = new int[1001];
        int i;
        for (int[] trip : trips) {
            for (i = trip[1]; i < trip[2]; i++) {
                journey[i] += trip[0];
                if (journey[i] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean carPooling1(int[][] trips, int capacity) {
        Arrays.sort(trips);
        List<Pair> list = new LinkedList<>();
        int current = 0;
        // 走的路程
        int journey = 0;
        int prePos = 0;

        for (int[] trip : trips) {
            int passenger = trip[0];
            int from = trip[1];
            int to = trip[2];
            // 放乘客
            Iterator<Pair> it = list.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                next.length = next.length - 1;
                if (next.length <= 0) {
                    current -= next.num;
                    it.remove();
                }
            }

            // 计算上车
            if (current + passenger > capacity) {
                return false;
            }
            // 上车
            Pair pair = new Pair(passenger, to - from);
            list.add(pair);
            current += passenger;
        }

        return true;
    }

    static class Pair {
        Integer length;
        Integer num;

        public Pair(Integer length, Integer num) {
            this.length = length;
            this.num = num;
        }
    }

    public static void main(String[] args) {
//        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
//        int capacity = 4;
        int[][] trips = {{2, 1, 5}, {3, 3, 7}};
        int capacity = 4;
        System.out.println(carPooling(trips, capacity));
    }
}
