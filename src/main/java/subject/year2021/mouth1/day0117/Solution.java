package subject.year2021.mouth1.day0117;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/17
 * Subject : 1232. 缀点成线
 * Label : ：简单，：数组，：几何，：数学
 * Describe :
 * 在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。
 *
 * 请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-it-is-a-straight-line
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    
//    由斜率公式得
//            (y1-y0)/(x1-x0)=(yi-y0)/(xi-x0)
//    防止除0，变换成相乘的形式
//            (y1-y0)*(xi-x0)==(x1-x0)*(yi-y0)
    
    public boolean checkStraightLine(int[][] c) {
        int len = c.length;
        for(int i=2;i<c.length;i++)
            if((c[1][1]-c[0][1])*(c[i][0]-c[0][0])!=(c[i][1]-c[0][1])*(c[1][0]-c[0][0]))
                return false;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean b = solution.checkStraightLine(new int[][]{{0,0},{0,1},{0,-1}});
        System.out.println(b);
    }
}
