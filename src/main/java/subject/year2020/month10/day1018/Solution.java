package subject.year2020.month10.day1018;

import subject.MyClass.ListNode;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/18
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode node = head;
        while(node != null){
            count++;
            node = node.next;
        }
//        System.out.println(count);
        node = head;
        if(count - n -1 < 0) return null; 
        for (int i = 0; i < count - n-1; i++) {
//            System.out.println(node.val);
            node = node.next;
        }
        node.next = node.next.next;
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        ListNode start = new ListNode(1);
//        start.next = new ListNode(2);
//        start.next.next = new ListNode(3);
//        start.next.next.next = new ListNode(4);
//        start.next.next.next.next = new ListNode(5);
        
        solution.removeNthFromEnd(start,1);
    }
}
