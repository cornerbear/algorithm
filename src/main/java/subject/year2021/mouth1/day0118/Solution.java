package subject.year2021.mouth1.day0118;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/19
 * Subject : 1640. 能否连接形成数组
 * Label : ：简单，：排序，：数组，：哈希表？
 * Describe :
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。请你以 任意顺序 连接 pieces 中的数组以形成 arr 。但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 *
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-array-formation-through-concatenation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public boolean canFormArray(int[] arr, int[][] pieces) {
        boolean flag = true; // 用于判断是否找到可以匹配的pieces[j]，如果一次都没有找到，说明无法链接，返回false
        for (int i = 0; i < arr.length; ) {
            flag = true;
            for (int j = 0; j < pieces.length; j++) {
                if(arr[i] == pieces[j][0]){
                    flag = false; //找到能匹配的pieces[j][0]，接下来匹配整个pieces[j][k]
                    i++;
                    for (int k = 1; k < pieces[j].length && i < arr.length; k++) {
                        if(arr[i] != pieces[j][k]){ //因为没有重复的元素，若本pieces[j][k]中，没有完全匹配，则说明无法链接（因为pieces[j][0]已经匹配过了），返回false
                            return false;
                        } else {
                            i++;
                        }
                    }
                    if(i == arr.length)
                        return true;
                }
            }
            if(flag){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.canFormArray(new int[]{85}, new int[][]{{85}});
        System.out.println(b);
        
//        {15,88}
//        {{88},{15}}
        
//        {49,18,16}
//        {{16,18,49}}

//        {49,18,16}
//        {{16},{49,18}}
        
//        {85}
//        {{85}}
    }
}
