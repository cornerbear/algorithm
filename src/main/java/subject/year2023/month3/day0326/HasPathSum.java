package subject.year2023.month3.day0326;

import subject.MyClass.TreeNode;

/**
 * @author : corner_bear
 * @subject : 112. 路径总和
 * @label : 简单 : 动态规划
 * @description :
 * 给你二叉树的根节点  root 和一个表示目标和的整数  targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和  targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @since : 2023/3/26 10:51
 */

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        return sum(root, 0, targetSum);
    }

    private boolean sum(TreeNode root, int curSum, int targetSum) {
        if(root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return curSum + root.val == targetSum;
        } else {
            boolean sum1 = sum(root.left, curSum + root.val, targetSum);
            boolean sum2 = sum(root.right, curSum + root.val, targetSum);
            return sum1 || sum2;
        }
    }

    public static void main(String[] args) {
        HasPathSum t = new HasPathSum();
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(4);
//        root.left.left = new TreeNode(11);
//        root.left.left.left = new TreeNode(7);
//        root.left.left.right = new TreeNode(2);
//
//        root.right = new TreeNode(8);
//        root.right.left = new TreeNode(13);
//        root.right.right = new TreeNode(4);
//        root.right.right.right = new TreeNode(1);

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(t.hasPathSum(root, 1));
    }
}
