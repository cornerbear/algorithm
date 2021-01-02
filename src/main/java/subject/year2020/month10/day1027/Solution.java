package subject.year2020.month10.day1027;

import subject.MyClass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/27
 */
public class Solution {

    
    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        
        pre(root,list);
        
        return list;
    }
    
    public void pre(TreeNode root, List<Integer> list){

        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            
            while(root != null){
                list.add(root.val);
                stack.add(root);
                root = root.left;
            }
            
            root = stack.pop().right;
        }
        
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(9);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(8);

        List<Integer> list = solution.preorderTraversal(root);
        for (Integer integer : list) {
            System.out.print(integer+" ");
        }
    }
}
