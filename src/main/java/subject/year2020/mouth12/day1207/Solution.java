package subject.year2020.mouth12.day1207;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/7
 */
public class Solution {
    public int matrixScore(int[][] A) {

        int m = A.length, n = A[0].length;
        for (int[] arr : A) {
            if (arr[0] == 0) {
                for (int i = 0; i < n; i++) {
                    if (arr[i] == 0) {
                        arr[i] = 1;
                    } else {
                        arr[i] = 0;
                    }
                }
            }
        }
        int ans = m * (1 << (n - 1));
        for (int i = 1; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (A[j][i] == 0) {
                    cnt++;
                }
            }
            ans += Math.max(cnt, m - cnt) * (1 << (n - i - 1));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}});
        System.out.println(i);
    }
}
