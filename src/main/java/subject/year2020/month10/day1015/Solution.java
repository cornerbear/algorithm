package subject.year2020.month10.day1015;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/15
 */
public class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> tempA = new LinkedList<>();
        Queue<Node> tempB = new LinkedList<>();

        tempA.offer(root);
        while (!tempA.isEmpty() ) {
            int size = tempA.size();
            //将队列中的节点取出来，并将左右节点存到另外一个队列
            for (int i = 0; i < size; i++) {
                Node poll = tempA.poll();
                if(poll != null){
                    if(poll.left != null){
                        tempB.offer(poll.left);
                    }
                    if(poll.right != null){
                        tempB.offer(poll.right);
                    }
                }
                
            }
            tempA.clear();
            if(!tempB.isEmpty()){
                //遍历队列，将next串起来
                int sizeB = tempB.size();
                Node temp = tempB.poll();
                tempA.offer(temp);
                for (int i = 0; i < sizeB; i++) {
                    temp.next = tempB.poll();
                    temp = temp.next;
                    tempA.offer(temp);
                }
            }
        }
        return root;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
