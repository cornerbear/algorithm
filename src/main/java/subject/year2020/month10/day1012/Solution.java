package subject.year2020.month10.day1012;

/**
 * Author : zhangxiaojian
 * Date : 2020/10/12
 */
public class Solution {
    
    int result = Integer.MIN_VALUE;
    private TreeNode preNode = null;
    
    public int getMinimumDifference(TreeNode root) {
        getMin(root);
        return result;
    }
    
    public void getMin(TreeNode root){
        if(root == null)
            return;
        getMin(root.left);
        if(preNode != null){
            result = Math.min(Math.abs(root.val - preNode.val),result);
        }
        preNode = root;
        getMin(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}