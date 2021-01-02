package subject.year2021.mouth1.day0101;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/2
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-place-flowers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 简单
 */
public class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        if(flowerbed == null || flowerbed.length == 0)
            return false;
        
        int[] newFlowerbed = new int[flowerbed.length+2];
        for (int i = 0; i < flowerbed.length; i++) {
            newFlowerbed[i+1] = flowerbed[i];
        } 
        flowerbed = newFlowerbed;
        
        for (int i = 1; i < flowerbed.length-1; i++) {
            if(flowerbed[i - 1] == 1 || flowerbed[i + 1] == 1 || flowerbed[i] == 1)
                continue;
            else {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1);
        System.out.println(b);
    }
}
