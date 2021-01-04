package subject.year2021.mouth1.day0104;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/4
 * 509. 斐波那契数
 * 简单
 */
public class Solution {

    public int fib(int n) {
        if(n == 0 || n == 1)
            return n;

        return fib(n-1)+fib(n-2);
    }
}
