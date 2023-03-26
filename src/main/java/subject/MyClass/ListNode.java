package subject.MyClass;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/9
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode create(int[] ints) {
        ListNode listNode = new ListNode();
        ListNode head = listNode;
        for (int i : ints) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        return head.next;
    }

    public static void print(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode start = new ListNode(1);
        start.next = new ListNode(2);
        start.next.next = new ListNode(3);
        start.next.next.next = new ListNode(4);
        start.next.next.next.next = new ListNode(5);
    }
}
