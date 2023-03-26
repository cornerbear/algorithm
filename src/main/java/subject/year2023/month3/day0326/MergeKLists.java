package subject.year2023.month3.day0326;

import subject.MyClass.ListNode;

import java.util.Arrays;

/**
 * @author : corner_bear
 * @subject : 23. 合并 K 个升序链表
 * @label : 困难 :
 * @description :
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @since : 2023/3/26 15:57
 */

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode head = result;
        while (true) {
            int tmp = 0;
            ListNode listNode = null;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null)
                    continue;
                if (listNode == null) {
                    tmp = i;
                    listNode = lists[i];
                }
                if (lists[i].val < listNode.val) {
                    tmp = i;
                    listNode = lists[i];
                }
            }
            if (listNode == null) {
                break;
            }
            result.next = listNode;
            result = result.next;
            lists[tmp] = lists[tmp].next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeKLists t = new MergeKLists();
        ListNode listNode1 = ListNode.create(new int[]{1, 4, 5});
        ListNode listNode2 = ListNode.create(new int[]{1, 3, 4});
        ListNode listNode3 = ListNode.create(new int[]{2, 6});
        ListNode[] listNodes = new ListNode[]{listNode1, listNode2, listNode3};

        ListNode listNode = t.mergeKLists(listNodes);
        ListNode.print(listNode);
    }
}
