package subject.year2023.month2.day0209;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/09
 * Subject : 1797. 设计一个验证系统
 * Label :中等 ：设计
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

    public static void main(String[] args) {
        // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
        AuthenticationManager a = new AuthenticationManager(5);

        // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
        a.renew("aaa", 1);
        // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
        a.generate("aaa", 2);
        // 时刻 6 时，只有 tokenId 为 "aaa" 的验证码未过期，所以返回 1 。
        System.out.println(a.countUnexpiredTokens(6));
        // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
        a.generate("bbb", 7);
        // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
        a.renew("aaa", 8);
        // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
        a.renew("bbb", 10);
        // tokenId 为 "bbb" 的验证码在时刻 15 过期，tokenId 为 "aaa" 的验证码在时刻 7 过期，所有验证码均已过期，所以返回 0 。
        System.out.println(a.countUnexpiredTokens(15));

    }
}

class AuthenticationManager {
    private Map<String, Integer> map = new HashMap<>();
    private Integer timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer expireTime = map.get(tokenId);
        if (expireTime != null) {
            if (expireTime > currentTime) {
                map.put(tokenId, currentTime + timeToLive);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Integer expireTime : map.values()) {
            if (currentTime > expireTime - timeToLive && currentTime < expireTime) {
                count++;
            }
        }
        return count;
    }
}
