package subject.year2020.month10.day1024N1024;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/24
 */
public class Solution {
    public int videoStitching(int[][] clips, int T) {
        
        int [][] dp = new int[clips.length + 1][T + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints,200);
        }

        for (int i = 1; i < dp.length; i++) {
            System.out.println(clips[i-1][0] + " " + clips[i-1][1]);
        }

        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] > o2[0])
                    return 1;
                else if(o1[0] < o2[0])
                    return -1;
                else 
                    return o2[1] - o1[1];
            }
        });
        System.out.println("==========");
        for (int i = 1; i < dp.length; i++) {
            System.out.println(clips[i-1][0] + " " + clips[i-1][1]);
        }
        
        
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(j >= clips[i-1][0] && j <= clips[i-1][1])
                    dp[i][j] = i;
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.videoStitching(new int[][]{{0, 2}, {4, 6}, {8, 10}, {1, 7}, {1, 5}, {5, 9}}, 10);
        System.out.println(i);
    }
}
