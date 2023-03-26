package subject.year2023.month3.day0326;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : corner_bear
 * @since : 2023/3/26 20:38
 * @subject : 169. 多数元素
 * @label : 简单
 * @description :
 * 给定一个大小为 n 的数组nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于⌊ n/2 ⌋的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/majority-element
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class MajorityElement {

    public int majorityElement(int[] nums) {
        Integer tmp = null;
        int count = 0;
        for (int num : nums) {
            if (tmp == null || count == 0) tmp = num;
            if (tmp == num) count++;
            else count--;
        }
        System.out.println(count);
        return tmp;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> num : map.entrySet()) {
            if (num.getValue() > nums.length / 2) {
                return num.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MajorityElement t = new MajorityElement();
        System.out.println(t.majorityElement(new int[]{1, 2, 3, 3, 3}));
    }
}
