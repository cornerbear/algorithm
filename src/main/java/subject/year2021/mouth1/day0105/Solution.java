package subject.year2021.mouth1.day0105;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/5
 * 830. 较大分组的位置
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 *
 * 例如，在字符串 s = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 *
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 *
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 *
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/positions-of-large-groups
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 数组，简单
 */
public class Solution {

    public List<List<Integer>> largeGroupPositions(String s) {
        
        s += ",";
        int len = s.length();
        
        List<List<Integer>> lists = new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            
            if(list.size() == 0){
                
                list.add(i);
                
            } else {
                if(s.charAt(list.get(0)) != s.charAt(i)){
                    if(i - list.get(0) >= 3){
                        list.add(i-1);
                        lists.add(list);
                    }
                    list = new ArrayList<>();
                    list.add(i);
                } 
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.largeGroupPositions("aaa");
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
