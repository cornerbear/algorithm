package subject.year2020.month10.day1006;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/6
 */
public class Solution1NO {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int nums[] = new int[N];
        for (int i = 1; i <= N; i++) {
            
        }
        return edges[0];
    }
    public int searchSon(int[] son,int[][] edges,int num){
        
        for (int i = 0; i < edges.length; i++) {
            if(son[1] == edges[i][0]){
                num++;
                searchSon(edges[i],edges,num);
            }
                
        }
        return num;
    }
    public static void main(String[] args) {
        Solution1NO solution1 = new Solution1NO();

        int[] ints = solution1.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
        for (int i = 0; i < ints.length; i++) {

            System.out.print(i + " ");
        }
    }
}
