package subject.year2020.month10.day1004;

import javafx.util.Pair;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/4
 */
public class Solution2 {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] table = new int[m+1][n+1];
        //外层循环，循环字符串个数
        for (int i = 0; i < strs.length; i++) {
            
            Pair<Integer, Integer> pair = count01(strs[i]);
            int count0 = pair.getKey();
            int count1 = pair.getValue();
            
            //循环0
            for (int j = 0; j <= m; j++) {
                //循环1
                for (int k = 0; k <= n; k++) {
                    if(j <= count0 || k <= count1)
                        table[j][k] = 0;
                    else {
                        table[j][k] = Math.max(table[j][k],table[j-count0][k-count1]+1);
                    }
                }
            }
        }
        
        return table[m][n];
    }
    public Pair<Integer,Integer> count01(String str){
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 0)
                count0++;
            else count1++;
        }
        return new Pair<>(count0,count1);
        
    }
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        int maxForm = solution2.findMaxForm(strs, m, n);
        System.out.println(maxForm);
    }
}
