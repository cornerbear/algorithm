package subject.year2020.mouth12.day1206;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/6
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> allList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> newList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i || i == 0){
                    newList.add(1);
                } else {
                    newList.add(allList.get(i-1).get(j-1)+allList.get(i-1).get(j));
                }
            }
            allList.add(newList);
        }
        
        return allList;
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> generate = solution.generate(1);
        for (List<Integer> list : generate) {
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println();
        }
    }
}
