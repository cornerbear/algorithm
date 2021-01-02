package subject.year2020.mouth12.day1208;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/8
 */
public class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack(list, S, S.length(), 0, 0, 0);
        return list;
    }

    public boolean backtrack(List<Integer> list, String S, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            // #1 本次想要截取的数字至少需要两位 但是最高位是0 不符合条件
            if (i > index && S.charAt(index) == '0') {
                break;
            }
            /**
             * #2
             * 这是为了取出多位数字 比如对于"11235813"而言 一直到index = 5时 都是取出1位字符就能满足数列条件
             * 但是index=6时 发现只能取出"1" 而此时的 sum=5+8=13 > curr=1
             * 所以根据 #3 处的判断 直接进入了下一次循环 这时index=7
             * 新的currLong = 1 * 10 + S.charAt(7) - '0' = 13
             */
            currLong = currLong * 10 + S.charAt(i) - '0';
            //如果此时的数字越界 结束循环
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                // #3  curr比期待的小 进入下一次循环 看看获得更大的数字后能否满足条件
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    //curr已经比期待的大 后面就不用尝试了 break之后 本层递归返回false 进入上一层的 #4 处
                    break;
                }
            }
            //符合数列条件 加入list
            list.add(curr);
            //如果本次递归返回true 进入下一次递归 索引开始的位置加1
            if (backtrack(list, S, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                // #4
                //如果递归返回了false 则撤销选择 进入下一次for循环 回到#2处 尝试将currLong和下一位结合
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> list = solution.splitIntoFibonacci("11235813");
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}