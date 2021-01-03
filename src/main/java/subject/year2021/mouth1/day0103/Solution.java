package subject.year2021.mouth1.day0103;

import subject.MyClass.ListNode;

/**
 * Author : zhangxiaojian
 * Date : 2021/1/3
 * 86. 分隔链表
 * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * 链表，中等
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        ListNode min = new ListNode(0);
        ListNode minHead = min;
        ListNode max = new ListNode(0);
        ListNode maxHead = max;
        
        while(head != null){
            if(head.val < x){
                min.next = head;
                min = min.next;
            } else {
                max.next = head;
                max = max.next;
            }
            head = head.next;
        }
        
        max.next = null;
        min.next = maxHead.next;
        
        return minHead.next;
    }
}
