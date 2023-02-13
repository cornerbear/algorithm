package subject.year2023.month2.day0209;

import java.util.HashMap;
import java.util.Map;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/09
 * Subject : 1797. 设计一个验证系统
 * Label :中等 ：设计
 * Describe ：
 * 你需要设计一个包含验证码的验证系统。每一次验证中，用户会收到一个新的验证码，这个验证码在 currentTime时刻之后 timeToLive秒过期。如果验证码被更新了，那么它会在 currentTime（可能与之前的 currentTime不同）时刻延长timeToLive秒。
 *
 * 请你实现AuthenticationManager类：
 *
 * AuthenticationManager(int timeToLive)构造AuthenticationManager并设置timeToLive参数。
 * generate(string tokenId, int currentTime)给定 tokenId，在当前时间currentTime 生成一个新的验证码。
 * renew(string tokenId, int currentTime)将给定 tokenId且 未过期的验证码在 currentTime时刻更新。如果给定tokenId对应的验证码不存在或已过期，请你忽略该操作，不会有任何更新操作发生。
 * countUnexpiredTokens(int currentTime)请返回在给定currentTime时刻，未过期的验证码数目。
 * 如果一个验证码在时刻t过期，且另一个操作恰好在时刻t发生（renew或者countUnexpiredTokens操作），过期事件优先于其他操作。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/design-authentication-manager
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
