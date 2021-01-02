package subject.year2020.month10.day1005;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/5
 */
public class SolutionTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrays = new ArrayList<>();
        arrays.addAll(Arrays.asList(2,1,4,2,5,1));
        System.out.println(arrays);
        arrays.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2)
                    return 1;
                else if(o1 < o2)
                    return -1;
                else return 0;
            }
        });

        System.out.println(arrays);
    }
}
