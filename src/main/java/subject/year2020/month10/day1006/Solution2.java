package subject.year2020.month10.day1006;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/6
 */
public class Solution2 {
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        
        while(n!=0) {
            int val = n%10;
            mul *= val;
            sum += val;
            n /= 10;
        }
        return mul-sum;
    }
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int i = solution2.subtractProductAndSum(234);
        System.out.println(i);
    }
}
