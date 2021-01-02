package subject.year2020.month10.day1020;

import subject.MyClass.ListNode;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/20
 * 
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1.2.3.4, 重新排列为 1.4.2.3.
 * 示例 2:
 *
 * 给定链表 1.2.3.4.5, 重新排列为 1.5.2.4.3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)
            return ;
        ListNode slow = head;
        ListNode fast = head;
        
        //将链表分成两段链表
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //后端翻转
        ListNode needReverse = slow.next;
        slow.next = null;
        needReverse = reverse(needReverse);
        
        //插入前端的缝隙
        ListNode cur = head;
        while(cur != null && needReverse != null){
            ListNode curSecond = needReverse;
            needReverse = needReverse.next;
            ListNode nextCur = cur.next;
            curSecond.next = cur.next;
            cur.next = curSecond;

            cur = nextCur;
        }
    }
    
    public ListNode reverse(ListNode head){
        
        ListNode newHead = null;
        
        ListNode now = head;
        
        ListNode temp = now;
        
        while (temp != null){
            
            temp = now.next;
            now.next = newHead;
            newHead = now;
            now = temp;
        }
        
        return newHead;
    }
    public static void main(String[] args) {
        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
        start.next.next = new ListNode(3);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        solution.reorderList(start);
        while(start != null){
            System.out.println(start.val);
            start = start.next;
        }
    }
}
