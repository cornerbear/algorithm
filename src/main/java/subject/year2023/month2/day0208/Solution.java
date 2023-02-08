package subject.year2023.month2.day0208;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/06
 * Subject : 1233. 删除子文件夹
 * Label :中等 ：树 ：数组
 * Describe ：
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * <p>
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
 * <p>
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
 * <p>
 * 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-sub-folders-from-the-filesystem
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public List<String> removeSubfolders(String[] folder) {
        List<String> res = new ArrayList<>();
        Set<String> set = Arrays.stream(folder).collect(Collectors.toSet());
        for (String s : set) {
            boolean flag = true;
            for (int i = s.length() - 1; i >= 0; --i) {
                if (s.charAt(i) == '/' && set.contains(s.substring(0, i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(s);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.removeSubfolders(new String[]{"/a", "/c/d/e", "/a/b", "/c/f", "/c/d"});
        System.out.println(strings);

    }
}
