package subject.year2023.month2.day0206;

import subject.MyClass.TreeNode;

/**
 * Author : zhangxiaojian
 * Date : 2023/02/06
 * Subject : 2331. 计算布尔二叉树的值
 * Label :简单 ：二叉树 ： 递归
 * Describe ：
 * 给你一棵 完整二叉树 的根，这棵树有以下特征：
 *
 * 叶子节点 要么值为 0 要么值为 1 ，其中 0 表示 False ，1 表示 True 。
 * 非叶子节点 要么值为 2 要么值为 3 ，其中 2 表示逻辑或 OR ，3 表示逻辑与 AND 。
 * 计算 一个节点的值方式如下：
 *
 * 如果节点是个叶子节点，那么节点的 值 为它本身，即 True 或者 False 。
 * 否则，计算 两个孩子的节点值，然后将该节点的运算符对两个孩子值进行 运算 。
 * 返回根节点 root 的布尔运算值。
 *
 * 完整二叉树 是每个节点有 0 个或者 2 个孩子的二叉树。
 *
 * 叶子节点 是没有孩子的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/evaluate-boolean-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {


    public static boolean evaluateTree(TreeNode root) {
        return evaluateNode(root);
    }

    private static boolean evaluateNode(TreeNode node) {
        if(node.val == 0) {
            return false;
        } else if(node.val == 1) {
            return true;
        } else if(node.val == 2) {
            return evaluateNode(node.left) || evaluateNode(node.right);
        } else if(node.val == 3) {
            return evaluateNode(node.left) && evaluateNode(node.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
////        root.left.left = new TreeNode(9);
//        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(0);
//        root.right.right = new TreeNode(1);
        boolean b = evaluateTree(root);
        System.out.println(b);
    }
}
