package subject.year2021.mouth1.day0116;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/16
 * Subject :682. 棒球比赛
 * Label :：简单，：数组
 * Describe :
 你现在是一场采用特殊赛制棒球比赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分。

 比赛开始时，记录是空白的。你会得到一个记录操作的字符串列表 ops，其中 ops[i] 是你需要记录的第 i 项操作，ops 遵循下述规则：

 整数 x - 表示本回合新获得分数 x
 "+" - 表示本回合新获得的得分是前两次得分的总和。题目数据保证记录此操作时前面总是存在两个有效的分数。
 "D" - 表示本回合新获得的得分是前一次得分的两倍。题目数据保证记录此操作时前面总是存在一个有效的分数。
 "C" - 表示前一次得分无效，将其从记录中移除。题目数据保证记录此操作时前面总是存在一个有效的分数。
 请你返回记录中所有得分的总和。
 */
public class Solution {

    public int calPoints(String[] ops) {
        int len = ops.length;
        int[] scores = new int[len];
        int i = 0;
        for (String str : ops) {
            if(str.equals("+")){
                scores[i] = scores[i-1] + scores[i-2];
                i++;
            } else if(str.equals("D")){
                scores[i] = scores[i-1] * 2;
                i++;
            } else if(str.equals("C")){
                scores[i - 1] = 0;
                i--;
            } else {
                scores[i] = Integer.parseInt(str);
                i++;
            }
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.calPoints(new String[]{"5", "2", "C", "D", "+"});
        System.out.println(i);
    }
}
