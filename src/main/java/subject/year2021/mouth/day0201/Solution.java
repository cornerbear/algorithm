package subject.year2021.mouth.day0201;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Author : zhangxiaojian
 * Date : 2021/2/2
 * Subject : 888. 公平的糖果棒交换
 * Label : 简单 ：数组 ：数学
 */
public class Solution {

    // 设答案为 {x,y}{x,y}
    // sumA−x+y=sumB+x−y
    // 化简得 ： x = y + (sumA−sumB) / 2
    // 所以对于b中任意一个数，看A中是否存在一个数，使得这个等式成立即可​	
    
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        // A = [2], B = [1,3] ------- [2,3]
        // delta 是 -1
        int delta = (sumA - sumB) / 2;
        Set<Integer> rec = new HashSet<Integer>();
        for (int num : A) {
            rec.add(num);
        }
        int[] ans = new int[2];
        for (int y : B) {
            int x = y + delta; // 1 2 
            // 判断A中是否存在 y+delta 
            if (rec.contains(x)) {
                ans[0] = x;
                ans[1] = y;
                break;
            }
        }
        return ans;
    }

}
