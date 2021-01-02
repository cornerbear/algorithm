package subject.year2020.mouth12.day1225;

import java.util.Arrays;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/25
 */
public class Solution {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLength = g.length;
        int sLength = s.length;

        int gi = 0;
        int kids = 0;
        for (int i = 0; i < sLength && gi < gLength; i++) {
            if(s[i] >= g[gi]){
                kids++;
                gi++;
            }
        }
        
        return kids;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int contentChildren = solution.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
        System.out.println(contentChildren);
    }
    
    
}
