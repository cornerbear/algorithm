package subject.year2020.month10.day1017;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/17
 */
public class Test {
    public static void main(String[] args) {
        String str = "hello world  nihao wohao";
        String[] s = str.split(" ");
        for (String s1 : s) {
            if(!"".equals(s1))
             System.out.print(new StringBuilder(s1).reverse()+" ");
        }
    }
}
