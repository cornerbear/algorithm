package subject.year2020.month11.day1123;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author : zhangxiaojian
 * Date : 2020/11/23
 */
public class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });
        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i][0] + "-" + points[i][1]);
        }
        int end = end = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if(end >= points[i][0]){
                end = Math.min(end,points[i][1]);
            } else {
                end = points[i][1];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int minArrowShots = solution.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
//        System.out.println(minArrowShots);
//        StringBuffer stringBuffer = new StringBuffer();
        char[] ach = new char[]{'a','b','c'};
        char[] bch = ach;
        System.out.println(ach);
        System.out.println(bch);
        bch[0] = 'c';
        System.out.println(ach);
    }
}
