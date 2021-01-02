package subject.year2020.mouth12.day1205;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/5
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] num = new int[26];

        //计数
        for (int i = 0; i < tasks.length; i++) {
            num[tasks[i] - 'A']++;
        }

        //排序
        

        for (int i : num) {
            System.out.print(i + " ");
        }

        boolean flag = true;
        int count = 0;
        lableB:
        while (flag) {
            sort(num);
            flag = false;
            int nTemp = 0;
            for (int i = 0; i < num.length && nTemp <= n; i++) {
                
                if (num[i] != 0) {
                    num[i]--;
                    nTemp++;
                    count++;
                    flag = true;
                    if(check(num)){
                        break lableB;
                    }
                }
            }
            if(nTemp <= n){
                count += (n-nTemp+1);
            }
            
        }
        System.out.println();
        for (int i : num) {
            System.out.print(i + " ");
        }

        System.out.println();
        return count;
    }
    public void sort(int [] num){
        int temp;
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[i] < num[i + 1]) {
                    temp = num[i];
                    num[i] = num[i + 1];
                    num[i + 1] = temp;
                }

            }
        }
    }
    public boolean check(int[] num){
        for (int i : num) {
            if(i != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.leastInterval(new char[]{'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'}, 2);
        System.out.println(i);
    }
}
