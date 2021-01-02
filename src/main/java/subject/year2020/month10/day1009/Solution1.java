package subject.year2020.month10.day1009;

import subject.MyClass.ListNode;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/9
 */
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        while(head != null){
            if(head.val == Integer.MIN_VALUE){
                return true;
            } else {
                head.val = Integer.MIN_VALUE;
                head = head.next;
            }
        }
        return false;
    }
    
    
}
