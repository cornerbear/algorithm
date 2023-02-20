package subject.year2023.month2.day0220;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author : flower_micro
 * Date : 2023/02/20
 * Subject : 2347. 最好的扑克手牌
 * Label : 简单 ：数组
 * Describe ：
 * 给你一个整数数组ranks和一个字符数组suit。你有5张扑克牌，第i张牌大小为ranks[i]，花色为suits[i]。
 * <p>
 * 下述是从好到坏你可能持有的 手牌类型：
 * <p>
 * "Flush"：同花，五张相同花色的扑克牌。
 * "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 * "Pair"：对子，两张大小一样的扑克牌。
 * "High Card"：高牌，五张大小互不相同的扑克牌。
 * 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型。
 * <p>
 * 注意：返回的字符串大小写需与题目描述相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-poker-hand
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class BestHand {

    // 同花，五张相同花色的扑克牌。
    private static final String FLUSH = "Flush";
    // 三条，有 3 张大小相同的扑克牌。
    private static final String THREE_OF_A_KIND = "Three of a Kind";
    // 对子，两张大小一样的扑克牌。
    private static final String PAIR = "Pair";
    // 高牌，五张大小互不相同的扑克牌。
    private static final String HIGH_CARD = "High Card";

    public String bestHand(int[] ranks, char[] suits) {
        // 同花
        char flushTmp = suits[0];
        boolean isFlush = true;
        for (int i = 1; i < 5; i++) {
            if (flushTmp != suits[i]) {
                isFlush = false;
                break;
            }
        }
        if (isFlush) return FLUSH;

        // 三条
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            String s = String.valueOf(ranks[i]);
            map.merge(s, 1, Integer::sum);
        }
        List<Integer> collect = map.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (Integer value : collect) {
            if (value >= 3) {
                return THREE_OF_A_KIND;
            }
            if (value >= 2) {
                return PAIR;
            }
        }

        return HIGH_CARD;
    }

    public static void main(String[] args) {
        BestHand bestHand = new BestHand();
//        System.out.println(bestHand.bestHand(new int[]{13, 2, 3, 1, 9}, new char[]{'a', 'a', 'a', 'a', 'a'}));
        System.out.println(bestHand.bestHand(new int[]{1, 1, 1, 2, 2}, new char[]{'a', 'b', 'c', 'a', 'a'}));
    }
}
