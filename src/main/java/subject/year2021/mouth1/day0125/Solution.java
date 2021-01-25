package subject.year2021.mouth1.day0125;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/30
 * Subject : 39. 组合总和
 * Label ：中等，：数组，：回溯算法
 */
public class Solution {

    private List<List<Integer>> res;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        
        backtrack(candidates,target,new ArrayList<>(),0);
        
        return res;
    }

    private void backtrack(int[] candidates, int remains, List<Integer> path, int start) {
        
        if(remains == 0){
            res.add(new ArrayList<>(path));
            return ;
        }

        for (int i = start; i < candidates.length; i++) {
            // 如果当前元素已经比剩余值大，直接返回
            if(candidates[i] > remains)
                return;
            
            // 如果两个元素一样，则忽略，因为可以单个元素可以重复使用，所以多于的没意义。
            if(i > 0 && candidates[i] == candidates[i-1]) continue;
            
            path.add(candidates[i]);
            
            backtrack(candidates,remains - candidates[i] , path, i);
            
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
