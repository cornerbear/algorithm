package subject.year2020.mouth12.day1203;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/3
 */
public class Solution {
    public int countPrimes(int n) {
        int[] isPrimes = new int[n+1];
        
        int count = 0;
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        for (int i = 2; i <= Math.sqrt(n-1); i++) {
            
            if(isPrimes[i] == 0){//是素数
                for (int j = i*i; j <= n; j+=i) {
                    isPrimes[j] = 1;
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if(isPrimes[i] == 0)
                count++;
        }
        
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.countPrimes(3);
        System.out.println(i);
    }
    
}
