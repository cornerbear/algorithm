package subject.year2020.month10.day1011;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/11
 */
public class MyTest {
    public static void main(String[] args) {
        
        int [] a = new int[]{1,2,3};
        int [] b = new int[]{5,6,7};
        b = a;
        b[1] = 0;
        System.out.println(b[1]);
        System.out.println(a[1]);
        
    }
}
