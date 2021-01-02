package subject.year2020.month10.day1023;

import java.util.ArrayList;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/23
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int length = list.size();
        
        for (int i = 0; i < length; i++) {
            if(!list.get(i).equals(list.get(length-i-1))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
        start.next.next = new ListNode(2);
        start.next.next.next = new ListNode(2);
        start.next.next.next.next = new ListNode(1);
        boolean palindrome = solution.isPalindrome(start);
        System.out.println(palindrome);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/*

if(head == null || head.next == null){
            return true;
        }
        if(head.next.next == null){
            return head.val == head.next.val;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        //找到中间节点
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(slow.next.next != null)
            slow = slow.next;
        
        ListNode start = head;
        ListNode end = slow;
        ListNode tempEnd = end;
        System.out.println("slow : "+slow.val);
        while(start.next != slow){
            //找到正确的尾指针位置
            while(end.next != null && end.next != tempEnd){
//                System.out.println(end.next.val + "+ " + tempEnd.val);
                end = end.next;
            }
//            System.out.println(1);
            System.out.println("start="+start.val+"="+"end="+end.val);
            if(start.val != end.val){
//                System.out.println(start.val +" + "+ end.val);
                return false;
            }
            tempEnd = end;
            end = slow;
            start = start.next;
        }
        System.out.println(start.val+"="+end.val);
        System.out.println(end.val);
        
        return true;
 */