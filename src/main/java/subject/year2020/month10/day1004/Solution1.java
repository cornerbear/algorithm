package subject.year2020.month10.day1004;

import year2020.MyClass.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode list = new ListNode();
        ListNode now = list;


        boolean temp = false;
        while (l1 != null && l2 != null) {
            int val = l1.val + l2.val;
            //判断进位
            temp = mod(temp,val);
            now.next = new ListNode(temp?val-10:val);
            
            now = now.next;
            l1 = l1.next;
            l2 = l2.next;

        }
        while (l1 != null) {
            int val = l1.val;
            
            temp = mod(temp,val);
            now.next = new ListNode(temp?val-10:val);
            
            now = now.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int val = l2.val;
            
            temp = mod(temp,val);
            now.next = new ListNode(temp?val-10:val);
            
            now = now.next;
            l2 = l2.next;
        }
        if (temp) {
            now.next = new ListNode(1);
        }
        return list.next;
    }
    public boolean mod(boolean temp, int val){
        if (temp) {
            val += 1;
        }
        //判断是否要进位
        if (val >= 10) {
            return true;//表示需要进位
        }
        return false;
    }
//

//    [2,4,3]
//            [5,6,4]
    //        now = null;
//        ListNode realList = new ListNode();
//        ListNode realNow = realList; 
//        while (list.next != null){
//            realNow.val = list.val;
//            realNow.next = new ListNode(list.val);
//            realNow = realNow.next;
//            list = list.next;
//        }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        listNode.val = 2;
        listNode = listNode.next;
    }
}

