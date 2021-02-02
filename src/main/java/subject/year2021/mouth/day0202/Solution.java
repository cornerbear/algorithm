package subject.year2021.mouth.day0202;

/**
 * Author : zhangxiaojian
 * Date : 2021/2/2
 * Subject : 424. 替换后的最长重复字符
 * Label :中等 ：双指针
 */
public class Solution {

    public int characterReplacement(String s, int k) {
        int[] num = new int[26];
        int len = s.length();
        int left = 0,right = 0;
        
        int maxn = 0;
        
        while (right < len) {
            num[s.charAt(right) - 'A']++;
            
            // maxn 是历史区间内，某个字母的最多出现次数
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
            
            // (right - left + 1) 就是区间的最大的长度，它并不是确定的某个区间，历史有某个maxn将这个区间撑大
            // 之后区间不断右移，
            // 直到
            //      该区间内某个字母的出现次数大于maxn，此时长度增加（right++），
            // 否则
            //      整体右移（left++，right++）
            
            if (right - left + 1 - maxn > k) {
                num[s.charAt(left) - 'A']--;
                left++;
            }
            // 区间长度增加 
            right++;
        }

        return right - left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.characterReplacement("BBBBAAACCCCC", 2);
        System.out.println(i);
    }

    // 例如 AAAABBCCCCC
    // 区间的长度不断增加，直到A结束，maxn为4，此时因为k=2所以区间还可以增长两个，区间为[AAAABB]，
    // 此时再向后遍历是k不够，所以left++，意味着区间整体后移，变为[AAABBC] 注意：此时maxn依旧为4,
    // 区间不断整体后移，直到[BBCCCC] 此时再向后遍历，num['C'-'A']++，maxn的值变为5,所以区间增加，right++
    // 要点：
    //      1. maxn代表的是历史某个区间内某个字母的最大出现次数，而不是当前区间
    //      2. 最终结束的区间并不是对应最大的区间，但是其长度是最大的长度


    public int characterReplacement1(String s, int k) {
//        int[] num = new int[26];
//        int len = s.length();
//        int left = 0,right = 0;
//
//        // 区间内，某个出现最多次数的字母的个数
//        int maxn = 0;
//
//        while (right < len) {
//            num[s.charAt(right) - 'A']++;
//
//            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);
//
//            // len = (right - left + 1) 为区间的长度，长度减去maxn就是其他的字母，也就是需要替换的个数 
//            // 替换数目是不变的=k,字母出现最大次数是可能变化的，因此，只有字母出现最大次数增加的情况，len才能拿到最大值
//            if (right - left + 1 - maxn > k) {
//                //这里要减的，因为left越过该点，会对最大值有影响
//                num[s.charAt(left) - 'A']--;
//                left++;
//            }
//            //走完这里的时候，其实right会多走一步
//            right++;
//        }

        //因为right多走一步，结果为(right-1)-left+1==right-left
//        return right - left;
        return 0;
    }
}
