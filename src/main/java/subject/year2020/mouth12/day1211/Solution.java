package subject.year2020.mouth12.day1211;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/11
 */
public class Solution {
    public String predictPartyVictory(String senate) {
        char[] array = senate.toCharArray();

        int countR = 0;
        int countD = 0;

        while (true) {


            int radiant = 0;
            int dire = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] == 'R') {
                    if (countR > 0) {
                        countR--;
                        array[i] = 'N';
                    } else {
                        countD++;
                        radiant++;
                    }
                } else if (array[i] == 'D') {
                    if (countD > 0) {
                        countD--;
                        array[i] = 'N';
                    } else {
                        countR++;
                        dire++;
                    }
                }
            }
            if(radiant == 0) return "Dire";
            else if(dire == 0) return "Radiant";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String rdd = solution.predictPartyVictory("RDD");
        System.out.println(rdd);
    }
}
