package subject.year2020.month11.day1122;

/**
 * Author : zhangxiaojian
 * Date : 2020/11/22
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] zimus = new int[133];
        int[] zimut = new int[133];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            zimus[(int)sc[i]]++;
        }
        for (int i = 0; i < tc.length; i++) {
            zimut[(int)tc[i]]++;
        }

        for (int i = 0; i < zimus.length; i++) {
            if(zimus[i] != zimut[i]){
                return false;
            }
        }
        return true;
    }
}
