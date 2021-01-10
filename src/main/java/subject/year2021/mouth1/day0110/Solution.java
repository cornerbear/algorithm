package subject.year2021.mouth1.day0110;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/10
 * 228. 汇总区间
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/summary-ranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ：数组 ：简单 ：小细节
 * 
 */
public class Solution {

    public List<String> summaryRanges(int[] nums) {
        
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < nums.length; ++i){
            if(i + 1 >= nums.length || nums[i] != nums[i + 1] - 1){ // 
                
                if(sb.length() > 0) 
                    sb.append("->");
                sb.append(nums[i]);
                list.add(sb.toString());
                sb = new StringBuilder();
            } else{
                if(sb.length() == 0) sb.append(nums[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.summaryRanges(new int[]{-1, 1, 2, 4, 5, 7,8});
        for (String s : list) {
            System.out.println(s);
        }
    }
}
