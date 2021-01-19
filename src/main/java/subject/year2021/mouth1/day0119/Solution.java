package subject.year2021.mouth1.day0119;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/19
 * Subject : 1346. 检查整数及其两倍数是否存在
 * Label : ：简单，：数组
 * Describe :
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 *
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 *
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-n-and-its-double-exist
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    // 1. 暴力
    public boolean checkIfExist1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] * 2;
            for (int j = 0; j < arr.length; j++)
                if (num == arr[j] && i != j)
                    return true;
        }
        return false;
    }
    // 2. map
    public boolean checkIfExist(int[] arr){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }

        for(int n = 0; n < arr.length; n++){
            if(map.containsKey(arr[n]*2) && map.get(arr[n]*2) != n){
                return true;
            }
        }
        return false;

    }
}
