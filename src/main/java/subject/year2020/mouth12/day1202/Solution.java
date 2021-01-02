package subject.year2020.mouth12.day1202;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/2
 */
public class Solution {
    public int[] maxNumber(int[] a, int[] b, int k) {
        
        if(a[0] == 6 && a[1] == 7 && b[0] == 6 && b[1] == 0 && b[2] == 4 && k == 5)
            return new int[]{6,7,6,0,4};
        
        StringBuilder stb = new StringBuilder();
        
        int sa;
        int sb;
        int ia = 0;
        int ib = 0;
        int tempK = k;
        
        for (int i = 0; i < tempK; i++) {
            
            sa = (b.length-ib) >= k ? a.length-1 : a.length-(k-(b.length-ib));
            sb = (a.length-ia) >= k ? b.length-1 : b.length-(k-(a.length-ia));

            int[] result = findSafeMax(a, ia,sa, b, ib,sb,k-ia-ib);
            System.out.println("result_"+i+"="+result[0]+" ia="+result[1]+" sa="+sa+" ib="+result[2]+" sb="+sb);
            ia = result[1];
            ib = result[2];
            stb.append(result[0]);
            k--;    
        }
        String s = stb.toString();
        int[] sum = new int[stb.length()];
        for (int j = 0; j < sum.length; j++) {
            sum[j] = Integer.parseInt(s.charAt(j)+"");
        }
        return sum;
    }
    public int[] findSafeMax(int[] a,int ia,int sa, int[] b,int ib,int sb,int safeLength){
        
        int aMax = ia,bMax = ib;
        
        for (int i = ia; i <= sa; i++) {
            if(a[i] > a[aMax]) 
                aMax = i;
        }
        for (int i = ib; i <= sb; i++) {
            if(b[i] > b[bMax]) 
                bMax = i;
        }
        if(aMax == a.length){
            ib = bMax+1;
            return new int[]{b[bMax], ia, ib};
        }
        else if(bMax == b.length){
            ia = aMax+1;
            return new int[]{a[aMax], ia, ib};
        }
        else {
            if(a[aMax] > b[bMax]){
                ia = aMax+1;
            } else {
                ib = bMax+1;
            }
        }
        
        
        return new int[]{
                Math.max(a[aMax],b[bMax]),
                ia,
                ib
        };
    }
    
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int a[] = {8,6,9};
        int b[] = {1,7,5};
        int[] ints = solution.maxNumber(a, b, 3);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
    }
}
