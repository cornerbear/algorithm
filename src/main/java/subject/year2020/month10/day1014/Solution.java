package subject.year2020.month10.day1014;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/14
 */
public class Solution {
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        
        //用来存放a-z出现的频率
        int[] res = new int[26];
        for (char c : A[0].toCharArray()) {
            res[c - 'a']++;
        }
        
        for (int i = 1; i < A.length; i++) {
            //用来存放临时的某个字符串的频率
            int [] temp = new int[26];
            for (char c : A[i].toCharArray()) {
                temp[c - 'a'] ++ ;
            }
            for (int j = 0; j < res.length; j++) {
                res[j] = Math.min(res[j],temp[j]);
            }
        }
        
        for (int i = 0; i < res.length; i++) {
            if(res[i] > 0){
                for (int j = 0; j < res[i]; j++) {
                    list.add((char)('a'+i)+"");
                }
            }
        }
        
        return list;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = solution.commonChars(new String[]{"bella", "label", "roller"});
        System.out.println(list);
    }
}
