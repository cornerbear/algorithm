package subject.year2020.mouth12.day1210;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/10
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {

        int money5 = 0;
        int money10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                money5++;
            } else if (bills[i] == 10) {
                if (money5 >= 1) {
                    money5--;
                    money10++;
                } else {
                    return false;
                }
            } else if (bills[i] == 20) {
                if ((10 * money10 + 5 * money5) >= 15) {
                    if (money10 >= 1) {
                        money10--;
                        if (money5 >= 1) {
                            money5--;
                        } else {
                            return false;
                        }
                    } else if (money5 >= 3) {
                        money5 -= 3;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20});
        System.out.println(b);
    }
}
