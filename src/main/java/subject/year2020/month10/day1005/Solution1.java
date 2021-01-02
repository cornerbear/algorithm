package subject.year2020.month10.day1005;

import java.util.*;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/5
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.fourSum(new int[]{-3,-2,0,7,6,4,0,4,-10,7,-3,4,3,10,1,8,2,7,3}, 6);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int length = nums.length;
        List<List<Integer>> arrayLists = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length && j != i; j++) {
                for (int k = 0; k < length && k != i && k != j; k++) {
                    for (int l = 0; l < length && l != i && l != j && l != k; l++) {

//                        System.out.println(nums[i]+" "+nums[j]+" "+nums[k]+" "+nums[l]);
                        if ((nums[i] + nums[j] + nums[k] + nums[l]) == target) {
                            List<Integer> integers = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(integers);
                            arrayLists.add(integers);

                        }
                    }
                }
            }
        }
        arrayLists.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
//                ArrayList<Integer> l1 = new ArrayList<>();
//                ArrayList<Integer> l2 = new ArrayList<>();
//                l1.addAll(o1);
//                l2.addAll(o2);
                
                Iterator<Integer> iterator1 = o1.iterator();
                Iterator<Integer> iterator2 = o2.iterator();
                while (iterator1.hasNext() && iterator2.hasNext()) {
                    Integer i1 = iterator1.next();
                    Integer i2 = iterator2.next();
                    if (i1 > i2) {
                        return 1;
                    } else if (i1 < i2) {
                        return -1;
                    } 
                }
                return 0;
            }
        });
        //去重
        HashSet<List<Integer>> set = new HashSet<>();
        set.addAll(arrayLists);

        List<List<Integer>> realList = new ArrayList<>();
        realList.addAll(set);


        return realList;
    }
    public int compareArrayList(List<Integer> l1, List<Integer> l2){
        Iterator<Integer> iterator1 = l1.iterator();
        Iterator<Integer> iterator2 = l2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            Integer i1 = iterator1.next();
            Integer i2 = iterator2.next();
            if (i1 > i2) {
                return 1;
            } else if (i1 < i2) {
                return -1;
            }
        }
        return 0;
    }
}