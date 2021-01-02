package subject.year2020.month10.day1013;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/13
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {

        ListNode node = new ListNode();
        ListNode pre = node;
        node.next = head;
        while(head != null && head.next != null){
            pre.next = head.next;
            head.next = head.next.next;
            pre.next.next = head;
            pre = head;
            head = pre.next;
        }
        return node.next;
        
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}