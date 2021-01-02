package subject.year2020.mouth12.day1222;

import subject.MyClass.TreeNode;
import subject.MyClass.TreeNode;

import java.util.*;

/**
 * Author : zhangxiaojian
 * Date : 2020/12/22
 */
public class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return null;
        Deque<TreeNode> q = new LinkedList<>();
        q.push(root);
        int flag = 0;
        
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = q.poll();
                list.add(treeNode.val);
                if(treeNode.left != null){
                    q.offer(treeNode.left);
                }
                if(treeNode.right != null){
                    q.offer(treeNode.right);
                }
            }
            if(flag%2==1)
            {
                Collections.reverse(list);
            }
            lists.add(list);
            flag++;
        }
        
        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
